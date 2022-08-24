package com.examen.federicowagner.dto;

import com.examen.federicowagner.entities.Vendor;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class NewVendorDTO implements Serializable {
    private String name;
    private double salary;

    @Override
    public String toString() {
        return "NewVendorDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
