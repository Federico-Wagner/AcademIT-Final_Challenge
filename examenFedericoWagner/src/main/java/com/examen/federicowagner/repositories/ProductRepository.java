package com.examen.federicowagner.repositories;

import com.examen.federicowagner.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository< Product, Long > {
    public List<Product> findAllByName(String name);
    public List<Product> findAllByCategory(String category);
}
