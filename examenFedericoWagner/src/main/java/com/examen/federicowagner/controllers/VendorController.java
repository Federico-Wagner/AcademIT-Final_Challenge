package com.examen.federicowagner.controllers;

import com.examen.federicowagner.dto.NewProductDTO;
import com.examen.federicowagner.dto.NewVendorDTO;
import com.examen.federicowagner.entities.Product;
import com.examen.federicowagner.entities.Vendor;
import com.examen.federicowagner.services.IProductService;
import com.examen.federicowagner.services.ISaleService;
import com.examen.federicowagner.services.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/vendor")
public class VendorController {

    @Autowired
    private IVendorService iVendorService;

    @GetMapping
    public List<Vendor> productList(){
        return this.iVendorService.getAllVendors();
    }

    @PostMapping
    public Vendor saveNewProduct(@RequestBody NewVendorDTO newVendorDTO){
        System.out.println(newVendorDTO);
        return this.iVendorService.saveNewVendor(new Vendor(newVendorDTO));
    }
}
