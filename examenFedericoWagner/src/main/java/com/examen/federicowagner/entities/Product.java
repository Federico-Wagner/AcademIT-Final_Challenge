package com.examen.federicowagner.entities;
import com.examen.federicowagner.dto.NewProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
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

    public Product() {}

    public Product(NewProductDTO newProductDTO) {
        this.name = newProductDTO.getName();
        this.price = newProductDTO.getPrice();
        this.category = newProductDTO.getCategory();
    }
}
