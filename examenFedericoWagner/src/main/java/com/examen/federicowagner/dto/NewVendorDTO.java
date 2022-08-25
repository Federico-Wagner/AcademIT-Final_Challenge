package com.examen.federicowagner.dto;
import lombok.Data;
import java.io.Serializable;

@Data
public class NewVendorDTO implements Serializable {
    private String name;
    private Double salary;

    @Override
    public String toString() {
        return "NewVendorDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
