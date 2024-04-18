package com.example.tredence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Products {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "productId cannot be blank")
    private String productId;

    @NotBlank(message = "category cannot be blank")
    private String category;

    @NotBlank(message = "brand cannot be blank")
    private String brand;
}
