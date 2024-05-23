package com.riwi.tonerink.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.tonerink.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
