package com.Induwara.simpleEcom.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private String category;
    private boolean productAvailable;
    private Date releaseDate;
    private int stockQuantity;

    private String imageName;
    private String imageType;
    @Lob // Large Object
    private byte[] imageData;    
}
