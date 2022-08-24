package com.examen.federicowagner.dto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class NewProductDTO implements Serializable {
    private String name;
    private double price;
    private String category;
}
