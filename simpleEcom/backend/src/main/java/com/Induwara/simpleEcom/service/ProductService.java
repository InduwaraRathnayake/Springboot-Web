package com.Induwara.simpleEcom.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Induwara.simpleEcom.model.Product;
import com.Induwara.simpleEcom.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    // private List<Product> products = new ArrayList<>(Arrays.asList(
    //     new Product(1, "Product 1", 100),
    //     new Product(2, "Product 2", 200),
    //     new Product(3, "Product 3", 300),
    //     new Product(4, "Product 4", 400)
    // ));

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product geProductByID(int id){
        return productRepository.findById(id).orElse(new Product());
    }

    public void addProduct(Product product){
        productRepository.save(product); //add and update both
    }                                   // .save() will check if the id is already there, if yes, it will update the product, else it will add the product

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductByID(int id) {
        productRepository.deleteById(id);
    }

}
