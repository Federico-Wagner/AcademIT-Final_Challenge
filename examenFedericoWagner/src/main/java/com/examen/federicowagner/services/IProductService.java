package com.examen.federicowagner.services;
import com.examen.federicowagner.entities.Product;
import java.util.List;
import java.util.Optional;


public interface IProductService {
    List<Product> getAllProducts();
    Product saveNewProduct(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAllByName(String name);
    List<Product> findAllByCategory(String category);

}
