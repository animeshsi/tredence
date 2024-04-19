package com.example.tredence.repository;


import com.example.tredence.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {


    Optional<Products> findByProductId(String productId);

    Page<Products> findAll(Specification<Products> specification, Pageable pageable);


}
