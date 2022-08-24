package com.examen.federicowagner.services;

import com.examen.federicowagner.commissions.CommissionManager;
import com.examen.federicowagner.dto.NewSaleDTO;
import com.examen.federicowagner.entities.Product;
import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.entities.SaleProduct;
import com.examen.federicowagner.entities.Vendor;
import com.examen.federicowagner.repositories.ProductRepository;
import com.examen.federicowagner.repositories.SaleRepository;
import com.examen.federicowagner.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private SaleRepository saleRepository;

//    @Autowired
//    private VendorRepository vendorRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CommissionManager commissionManager;

//    @Override
//    public Vendor newSale(NewSaleDTO newSaleDTO) throws Exception {
//        try{
//            //Buscar vendedor
//            Vendor vendor = this.vendorRepository.findById(newSaleDTO.getVendor_id()).get();
//            //Crear venta
//            Sale sale = new Sale();
//
//            List<SaleProduct> SellList = new ArrayList<>();
//            double totalPrice = 0;
//            int productCount = 0;
//
//            for (int i=0; i<newSaleDTO.getCart().size(); i++) {
//                //Grab data from DTO
//                Long Product_id = newSaleDTO.getCart().get(i).getProduct_id();
//                Long amount = newSaleDTO.getCart().get(i).getAmount();
//                productCount += amount;
//
//                //Find product data and accumulate total value of Sale
//                Product product = this.productRepository.findById(Product_id).get();
//                totalPrice += amount * product.getPrice();
//
//                //Generate saleProduct and append it to the sellList
//                SaleProduct saleProduct1 = new SaleProduct(null , amount, product, sale );
//                SellList.add(saleProduct1);
//            }
//            //Assign all data to the Sale object
//            sale.setSaleProducts(SellList);
//            sale.setVendor(vendor);
//            sale.setTotalPrice(totalPrice);
//
//            //Save Sale in DB  (nested object will create rows in SaleProduct table)
//            this.saleRepository.save(sale);
//
////            //COMMISSION CALCULATION
////            double ONE_PRODUCT_COMMISSION = 0.05;
////            double MULTIPLE_PRODUCT_COMMISSION = 0.10;
////
////            double commission = vendor.getCommissions();
////            if (productCount == 1){
////                commission += totalPrice * ONE_PRODUCT_COMMISSION;
////            }else{
////                commission += totalPrice * MULTIPLE_PRODUCT_COMMISSION;
////            }
//            double vendorCommissions = vendor.getCommissions();
//            double saleCommission = commissionManager.calculateCommission(totalPrice, productCount);
//
//            vendor.setCommissions(vendorCommissions + saleCommission);
//
//            return this.vendorRepository.save(vendor);
//
//        }catch (Exception e){
//            throw new Exception("Error during NEW SALE create",e);
//        }
//    }

    @Override
    public Sale save(Sale sale) {
        return this.saleRepository.save(sale);
    }
}
