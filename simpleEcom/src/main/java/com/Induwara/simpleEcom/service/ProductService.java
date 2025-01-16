package com.Induwara.simpleEcom.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Induwara.simpleEcom.model.Product;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1, "Product 1", 100),
        new Product(2, "Product 2", 200),
        new Product(3, "Product 3", 300)
    ));

    public List<Product> getProducts(){
        return products;
    }

    public Product geProductByID(int id){
        return products.stream()
            .filter(p -> p.getProdID() == id) 
            .findFirst()
            .get();
    }
    // public Product geProductByID(int id){
    //     return products.stream()
    //         .filter(p -> p.getProdID() == id) 
    //         .findFirst()
    //         .orElse(new Product(100 , "Product not found", 0));
    //         
    // }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index =0;
        for (int i=0; i<products.size(); i++){
            if(products.get(i).getProdID() == product.getProdID()){
                index = i;
                break;
            }
        }
        products.set(index, product);
    }

    public void deleteProductByID(int id) {
        products.removeIf(p -> p.getProdID() == id);
    }

}
