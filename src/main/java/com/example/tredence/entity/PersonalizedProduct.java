package com.example.tredence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class PersonalizedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "shopper_id", referencedColumnName = "id")
    private Shoppers shoppers;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products products;


    private double relevancyScore;
}
