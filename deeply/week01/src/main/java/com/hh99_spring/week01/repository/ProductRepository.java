package com.hh99_spring.week01.repository;


import com.hh99_spring.week01.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}