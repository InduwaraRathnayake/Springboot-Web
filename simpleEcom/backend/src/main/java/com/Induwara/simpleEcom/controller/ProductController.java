package com.Induwara.simpleEcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Induwara.simpleEcom.model.Product;
import com.Induwara.simpleEcom.service.ProductService;

@RestController
@CrossOrigin // to allow requests from the frontend (CORS policy)
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){ //with help of ResponseEntity we can send status codes along with the response
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        Product product = service.getProductById(id);
        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){ //RequestPart is used to bind the request body to the method parameter, and MultipartFile is used to get the image file from the request
        
        try{
            Product p = service.addProduct(product, imageFile);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/product/{productID}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productID){
        Product product = service.getProductById(productID);
        // if(product != null){
        //     return ResponseEntity.ok()
        //             .header("Content-Disposition", "attachment; filename=\"" + product.getImageName() + "\"")
        //             .body(product.getImageData());
        // }
        // else{
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }

        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }
}
