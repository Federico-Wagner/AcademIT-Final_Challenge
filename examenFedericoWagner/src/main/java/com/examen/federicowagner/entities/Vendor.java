package com.examen.federicowagner.entities;
import com.examen.federicowagner.dto.NewVendorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "vendors")
@AllArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "commissions")
    private Double commissions;

    @OneToMany(mappedBy = "vendor")
    @JsonIgnore //Mi santo grial
    private List<Sale> sales;

    public Vendor() {
    }
    public Vendor(NewVendorDTO newVendorDTO) {
        this.name = newVendorDTO.getName();
        this.salary = newVendorDTO.getSalary();
        this.commissions = 0.0;
    }
}
