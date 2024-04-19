package com.example.tredence.repository;


import com.example.tredence.entity.Shoppers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopperRepository extends JpaRepository<Shoppers,Long> {
    Optional<Shoppers> findByShopperId(String shopperId);
}
