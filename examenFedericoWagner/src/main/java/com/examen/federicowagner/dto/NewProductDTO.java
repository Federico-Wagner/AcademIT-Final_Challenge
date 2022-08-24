package com.examen.federicowagner.dto;
import lombok.Data;
import java.io.Serializable;

@Data
public class NewProductDTO implements Serializable {
    private String name;
    private double price;
    private String category;
}
