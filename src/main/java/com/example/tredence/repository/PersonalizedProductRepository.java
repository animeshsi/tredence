package com.example.tredence.repository;

import com.example.tredence.entity.PersonalizedProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonalizedProductRepository extends JpaRepository<PersonalizedProduct,Long> {
    

        @Query("SELECT pp FROM PersonalizedProduct pp JOIN pp.products p WHERE " +
                "(:category IS NULL OR p.category = :category) " +
                "AND (:brand IS NULL OR p.brand = :brand) " +
                "AND (:productId IS NULL OR p.productId = :productId) " +
                "ORDER BY CASE WHEN :sortBy = 'relevancyScore' THEN pp.relevancyScore ELSE null END DESC, " +
                "CASE WHEN :sortBy = 'category' THEN p.category ELSE null END ASC, " +
                "CASE WHEN :sortBy = 'brand' THEN p.brand ELSE null END ASC")
        Page<PersonalizedProduct> findAll(String category, String brand, String productId,
                                          String sortBy, Pageable pageable);


}
