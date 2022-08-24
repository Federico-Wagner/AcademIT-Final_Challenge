package com.examen.federicowagner.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "sales")
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)

    private List<SaleProduct> saleProducts;


//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL
//    )
//    @JoinTable(
//            name = "sales_products",
//            joinColumns = @JoinColumn(name = "sale_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    @JsonIgnoreProperties("sale")
//    private List<Product> products;

    public Sale() {
    }
}
