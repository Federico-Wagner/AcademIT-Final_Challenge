package com.examen.federicowagner.services;

import com.examen.federicowagner.dto.NewSaleDTO;
import com.examen.federicowagner.entities.Sale;
import com.examen.federicowagner.entities.Vendor;

public interface ISaleService {

//    public Vendor newSale(NewSaleDTO newSaleDTO) throws Exception;

    public Sale save(Sale sale);


}
