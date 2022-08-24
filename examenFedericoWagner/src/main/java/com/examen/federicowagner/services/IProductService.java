package com.examen.federicowagner.services;
import com.examen.federicowagner.entities.Product;
import java.util.List;
import java.util.Observable;
import java.util.Optional;


public interface IProductService {

    public List<Product> getAllProducts();
    public Product saveNewProduct(Product product);
    public List<Product> findAllByName(String name);
    public List<Product> findAllByCategory(String category);

}
