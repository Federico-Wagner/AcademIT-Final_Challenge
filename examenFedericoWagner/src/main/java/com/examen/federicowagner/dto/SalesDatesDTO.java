package com.examen.federicowagner.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class SalesDatesDTO {
    LocalDate dateFrom;
    LocalDate dateUpTo;
}
