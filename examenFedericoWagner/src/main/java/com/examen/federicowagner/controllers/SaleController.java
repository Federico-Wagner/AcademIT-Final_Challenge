package com.examen.federicowagner.controllers;


import com.examen.federicowagner.dto.NewSaleDTO;
import com.examen.federicowagner.entities.Vendor;
import com.examen.federicowagner.services.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/sale")
public class SaleController {

    @Autowired
    private ISaleService iSaleService;

    @PostMapping
    public ResponseEntity<?> saveNewSale(@RequestBody NewSaleDTO newSaleDTO){
        System.out.println(newSaleDTO);

        return new ResponseEntity<>(this.iSaleService.newSale(newSaleDTO), HttpStatus.OK);
    }
}
