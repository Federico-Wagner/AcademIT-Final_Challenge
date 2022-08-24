package com.examen.federicowagner.controllers;

import com.examen.federicowagner.commissions.CommissionManager;
import com.examen.federicowagner.dto.NewSaleDTO;
import com.examen.federicowagner.entities.Product;
import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.entities.SaleProduct;
import com.examen.federicowagner.entities.Vendor;
import com.examen.federicowagner.repositories.ProductRepository;
import com.examen.federicowagner.repositories.SaleRepository;
import com.examen.federicowagner.repositories.VendorRepository;
import com.examen.federicowagner.services.IProductService;
import com.examen.federicowagner.services.ISaleService;
import com.examen.federicowagner.services.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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


    @PostMapping
    public ResponseEntity<?> saveNewSale(@RequestBody NewSaleDTO newSaleDTO) throws Exception {
        try{
            //Find Vendor by Id
            Vendor vendor = this.iVendorService.findById(newSaleDTO.getVendor_id()).get();
            //Create empty Sale
            Sale sale = new Sale();

            List<SaleProduct> SellList = new ArrayList<>();
            double totalPrice = 0;
            int productCount = 0;

            for (int i=0; i<newSaleDTO.getCart().size(); i++) {
                //Grab data from DTO
                Long Product_id = newSaleDTO.getCart().get(i).getProduct_id();
                Long amount = newSaleDTO.getCart().get(i).getAmount();
                productCount += amount;

                //Find product data and accumulate total value of Sale
                Product product = this.iProductService.findById(Product_id).get();
                totalPrice += amount * product.getPrice();

                //Generate saleProduct and append it to the sellList
                SaleProduct saleProduct1 = new SaleProduct(null , amount, product, sale );
                SellList.add(saleProduct1);
            }
            //Assign all data to the Sale object
            sale.setSaleProducts(SellList);
            sale.setVendor(vendor);
            sale.setTotalPrice(totalPrice);


            //COMMISSION CALCULATION
            double saleCommission = commissionManager.calculateCommission(totalPrice, productCount);
            double vendorCommissions = vendor.getCommissions();
            vendor.setCommissions(vendorCommissions + saleCommission);

            //Save Sale and Vendor commission update
            this.iSaleService.save(sale);     //(nested object will create rows in SaleProduct table)
            LOGGER.log(Level.INFO, "NEW SALE: " + vendor.getName() + " : $" + totalPrice);
            this.iVendorService.save(vendor);
            LOGGER.log(Level.INFO, "COMMISSION ADDITION TO: " + vendor.getName() + " : $" + saleCommission);
            return new ResponseEntity<>(totalPrice, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("Error during NEW SALE create",e);
        }
    }
}
