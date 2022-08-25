package com.examen.federicowagner.services;

import com.examen.federicowagner.dto.NewSaleDTO;
import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.entities.Vendor;

public interface ISaleService {
    Sale save(Sale sale);

}
