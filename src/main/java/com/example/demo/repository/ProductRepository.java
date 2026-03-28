package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository provides all the save, find, and delete methods for you


    Optional<Product> findByProductName(String productName);
    boolean existsByProductName(String productName);
}