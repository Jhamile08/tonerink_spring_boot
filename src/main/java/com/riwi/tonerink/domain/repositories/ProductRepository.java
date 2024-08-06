package com.riwi.tonerink.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.tonerink.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
