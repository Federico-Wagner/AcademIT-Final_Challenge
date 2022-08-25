package com.examen.federicowagner.controllers;

import com.examen.federicowagner.dto.NewProductDTO;
import com.examen.federicowagner.entities.Product;
import com.examen.federicowagner.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/product")
public class ProductController {
    private final Logger LOGGER = Logger.getLogger( ProductController.class.getName());
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public List<Product> productList(){
        return this.iProductService.getAllProducts();
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody NewProductDTO newProductDTO){
        Product newProduct = this.iProductService.saveNewProduct(new Product(newProductDTO));
        LOGGER.log(Level.INFO, "NEW PRODUCT REGISTERED: " + newProduct.getName() + " : $" + newProduct.getPrice());
        return newProduct;
    }
    //localhost:9080/api/v1/product/name?search=Tornillo allen M8x20
    @GetMapping("/name")
    public List<Product> productByName(@RequestParam("search") String search){
        return this.iProductService.findAllByName(search);
    }

    //localhost:9080/api/v1/product/category?search=Tornillos
    @GetMapping("/category")
    public List<Product> productByCategory(@RequestParam("search") String search){
        return this.iProductService.findAllByCategory(search);
    }

}
