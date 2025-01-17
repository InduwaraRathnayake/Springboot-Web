package com.Induwara.simpleEcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Induwara.simpleEcom.model.Product;

@Repository //within <> , mention the entity class and the type of the primary key
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
