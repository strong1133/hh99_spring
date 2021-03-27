package com.hh99_spring.re_week02_03.repository;

import com.hh99_spring.re_week02_03.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUserId(Long userid);
}
