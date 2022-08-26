package com.examen.federicowagner.controllers;

import com.examen.federicowagner.commissions.CommissionManager;
import com.examen.federicowagner.dto.NewSaleDTO;
import com.examen.federicowagner.dto.SalesDatesDTO;
import com.examen.federicowagner.entities.Product;
import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.entities.SaleProduct;
import com.examen.federicowagner.entities.Vendor;
import com.examen.federicowagner.services.IProductService;
import com.examen.federicowagner.services.ISaleService;
import com.examen.federicowagner.services.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/sale")
public class SaleController {
    private final Logger LOGGER = Logger.getLogger( SaleController.class.getName());
    @Autowired
    private CommissionManager commissionManager;
    @Autowired
    private ISaleService iSaleService;
    @Autowired
    private IVendorService iVendorService;
    @Autowired
    private IProductService iProductService;
    @GetMapping
    public ResponseEntity<?> saleQuery() {

        List<Sale> vendorSales = this.iSaleService.findByVendorId(1L);

        return new ResponseEntity<>(vendorSales,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> lastMonthVendorSales(@PathVariable Long id) {
        System.out.println(id);

        List<Sale> lastMonthVendorSales = this.iSaleService.lastMonthVendorSales(id);

        return new ResponseEntity<>(lastMonthVendorSales,HttpStatus.OK);
    }
    @GetMapping("/{id}/dates")
    public ResponseEntity<?> betweenDatesVendorSales(@PathVariable Long id, @RequestBody SalesDatesDTO salesDatesDTO) {
        System.out.println(salesDatesDTO);
        System.out.println(id);

        LocalDate dateFrom = LocalDate.parse(salesDatesDTO.getDateFrom().toString());
        LocalDate dateUpTo = LocalDate.parse(salesDatesDTO.getDateUpTo().toString());

        System.out.println("from: " + dateFrom );
        System.out.println("upTo: " + dateUpTo);

        List<Sale> lastMonthVendorSales = this.iSaleService.betweenDatesVendorSales(id, dateFrom, dateUpTo);

        return new ResponseEntity<>(lastMonthVendorSales,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveNewSale(@RequestBody NewSaleDTO newSaleDTO) throws Exception {
            //Find Vendor by Id
            Vendor vendor;
            try {
                vendor = this.iVendorService.findById(newSaleDTO.getVendor_id()).get();
            } catch (NoSuchElementException e) {
                throw new Exception("Couldn't find Vendor with id:" + newSaleDTO.getVendor_id(), e);
            }

            //Create empty Sale
            Sale sale = new Sale();

            List<SaleProduct> SellList = new ArrayList<>();
            double totalPrice = 0.0;
            int productCount = 0;

            for (int i = 0; i < newSaleDTO.getCart().size(); i++) {
                //Grab data from DTO
                Long Product_id = newSaleDTO.getCart().get(i).getProduct_id();
                Long amount = newSaleDTO.getCart().get(i).getAmount();
                productCount += amount;

                //Find product data and accumulate total value of Sale
                Product product;
                try {
                    product = this.iProductService.findById(Product_id).get();
                } catch (NoSuchElementException e) {
                    throw new Exception("Couldn't find Product with id:" + Product_id, e);
                }

                totalPrice += amount * product.getPrice();

                //Generate saleProduct and append it to the sellList
                SaleProduct saleProduct1 = new SaleProduct(null, amount, product, sale);
                SellList.add(saleProduct1);
            }

            //COMMISSION CALCULATION
            Double saleCommission = commissionManager.calculateCommission(totalPrice, productCount);
            Double vendorCommissions = vendor.getCommissions() == null ? 0.0 : vendor.getCommissions(); //HOT FIX
            vendor.setCommissions(vendorCommissions + saleCommission);

            //SALE DATA INTEGRATION
            sale.setSaleProducts(SellList);
            sale.setVendor(vendor);
            sale.setTotalPrice(totalPrice);
            sale.setSaleCommission(saleCommission);
            sale.setDate(LocalDate.now());

            //SALE SAVE
            try {
                this.iSaleService.save(sale);     //(nested object will create rows in SaleProduct table)
                LOGGER.log(Level.INFO, "NEW SALE: " + vendor.getName() + " : $" + totalPrice);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "FAILED NEW SALE: " + vendor.getName() + " : $" + totalPrice);
                throw new Exception("Couldn't save new Sale on DB", e);
            }
            //VENDOR TOTAL COMMISSION UPDATE
            try {
                this.iVendorService.save(vendor);
                LOGGER.log(Level.INFO, "COMMISSION ADDITION TO: " + vendor.getName() + " : $" + saleCommission);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, " FAILED COMMISSION ADDITION TO: " + vendor.getName() + " : $" + saleCommission);
                throw new Exception("Couldn't update Vendor commission"+ vendor.getName()+ " "+ saleCommission, e);
            }
            return new ResponseEntity<>(sale, HttpStatus.OK);
    }
}
