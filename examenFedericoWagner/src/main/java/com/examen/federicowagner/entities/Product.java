package com.examen.federicowagner.entities;

import com.examen.federicowagner.dto.NewProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "category")
    private String category;


    @OneToMany(mappedBy = "sale")
//    @JsonIgnoreProperties("saleProducts")
//    @JsonIncludeProperties({"name", "price", "category"})
    private List<SaleProduct> saleProducts;




//    @ManyToMany(mappedBy = "products")
//    private List<Sale> sale;

    public Product() {}

    public Product(NewProductDTO newProductDTO) {
        this.name = newProductDTO.getName();
        this.price = newProductDTO.getPrice();
        this.category = newProductDTO.getCategory();
    }
}
