package com.examen.federicowagner.commissions;
//    ONE_PRODUCT_COMMISSION = 0.05;
//    MULTIPLE_PRODUCT_COMMISSION = 0.10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommissionManager {
    // APPLICATION COMMISSION CONSTANTS
    @Value("${TWO_PRODUCT_COMMISSION}")
    String TWO_PRODUCT_COMMISSION;
    @Value("${TREE_PLUS_PRODUCT_COMMISSION}")
    String TREE_PLUS_PRODUCT_COMMISSION;

   public Double calculateCommission(Double finalPrice, int amount ){
        //COMMISSION CALCULATION
       double commission;
        if (amount == 1){
            commission = finalPrice * Double.parseDouble(TWO_PRODUCT_COMMISSION);
        }else{
            commission = finalPrice * Double.parseDouble(TREE_PLUS_PRODUCT_COMMISSION);
        }
        return commission;
    }
}
