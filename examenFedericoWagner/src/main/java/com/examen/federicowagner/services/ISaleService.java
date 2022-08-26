package com.examen.federicowagner.services;

import com.examen.federicowagner.dto.NewSaleDTO;
import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.entities.Vendor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISaleService {
    Sale save(Sale sale);
    List<Sale> findByVendorId(Long vendorId);
    public List<Sale> lastMonthVendorSales(Long vendorId);
    List<Sale> betweenDatesVendorSales(Long vendorId, LocalDate date1, LocalDate date2);
}
