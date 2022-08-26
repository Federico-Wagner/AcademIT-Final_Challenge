package com.examen.federicowagner.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
    private Double totalPrice;

    @Column(name = "sale_commission")
    private Double saleCommission;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @OneToMany(mappedBy = "product")
    @JsonIgnore //Mi santo grial
    private List<SaleProduct> saleProducts;

    public Sale() {
    }
}
