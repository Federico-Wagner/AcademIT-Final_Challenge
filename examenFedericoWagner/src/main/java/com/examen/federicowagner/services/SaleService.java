package com.examen.federicowagner.services;

import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SaleService implements ISaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale save(Sale sale) {
        return this.saleRepository.save(sale);
    }
    @Override
    public List<Sale> findByVendorId(Long vendorId) {
        return this.saleRepository.findAllByVendorId(vendorId);
    }
    @Override
    public List<Sale> lastMonthVendorSales(Long vendorId) {
        List<Sale> lastMonthVendorSales  = this.saleRepository.findAllByVendorId(vendorId)
                .stream()
                .filter(sale -> (sale.getDate().isAfter(LocalDate.now().minusDays(LocalDate.now().getDayOfMonth()))))
                .collect(Collectors.toList());
        return lastMonthVendorSales;
    }


    @Override
    public List<Sale> betweenDatesVendorSales(Long vendorId, LocalDate date1, LocalDate date2) {
        return this.saleRepository.findAllByVendorIdAndDateAfterAndDateBeforeOrderByDate(vendorId, date1, date2);
    }
}
