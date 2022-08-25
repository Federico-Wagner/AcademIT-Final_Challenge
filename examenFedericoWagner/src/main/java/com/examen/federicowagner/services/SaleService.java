package com.examen.federicowagner.services;

import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SaleService implements ISaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale save(Sale sale) {
        return this.saleRepository.save(sale);
    }
}
