package com.hh99_spring.week04.controller;


import com.hh99_spring.week04.domain.Product;
import com.hh99_spring.week04.domain.ProductMypriceRequestDto;
import com.hh99_spring.week04.domain.ProductRepository;
import com.hh99_spring.week04.domain.ProductRequestDto;
import com.hh99_spring.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProduct (){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto){
        Product product = new Product(productRequestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto productMypriceRequestDto){
        return productService.update(id, productMypriceRequestDto);
    }

    @DeleteMapping("/api/products/{id}")
    public Long deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return id;
    }
}
