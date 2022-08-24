package com.examen.federicowagner.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.util.List;


@Data
public class NewSaleDTO implements Serializable {
    private Long vendor_id;
    private List<ProdDetail> cart;

//    @Data
//    @AllArgsConstructor
//    private static class ProdDetail {
//        private Long product_id;
//        private Long amount;
//
//        @Override
//        public String toString() {
//            return "{" +
//                    "product_id=" + product_id +
//                    ", amount=" + amount +
//                    '}';
//        }
//    }
}

// DATA STRUCTURE RECEIVED FROM FRONT
//{
//        "vendor_id": 2,
//        "cart":[
//        {
//        "product_id" : 1,
//        "amount" :  2
//        },
//        {
//        "product_id" : 2,
//        "amount" :  5
//        },
//        {
//        "product_id" : 3,
//        "amount" :  7
//        }
//        ]
//}