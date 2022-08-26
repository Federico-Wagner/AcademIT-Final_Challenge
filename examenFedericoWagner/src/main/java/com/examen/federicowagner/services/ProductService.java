package com.examen.federicowagner.services;
import com.examen.federicowagner.entities.Product;
import com.examen.federicowagner.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product saveNewProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Optional<Product> findById(Long id){
        return this.productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByName(String name) {
        return this.productRepository.findAllByName(name);
    }

    @Override
    public List<Product> findAllByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }
}
