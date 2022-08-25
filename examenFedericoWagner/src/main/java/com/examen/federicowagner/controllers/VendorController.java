package com.examen.federicowagner.controllers;

import com.examen.federicowagner.dto.NewVendorDTO;
import com.examen.federicowagner.entities.Vendor;
import com.examen.federicowagner.services.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/vendor")
public class VendorController {
    private final Logger LOGGER = Logger.getLogger( VendorController.class.getName());
    @Autowired
    private IVendorService iVendorService;

    @GetMapping
    public List<Vendor> productList(){
        return this.iVendorService.getAllVendors();
    }

    @PostMapping
    public Vendor saveNewProduct(@RequestBody NewVendorDTO newVendorDTO){
        System.out.println(newVendorDTO);
        Vendor newVendor = this.iVendorService.saveNewVendor(new Vendor(newVendorDTO));
        LOGGER.log(Level.INFO, "NEW VENDOR REGISTERED: " + newVendor.getName() + " : $" + newVendor.getSalary());
        return newVendor;
    }
}
