package com.hh99_spring.re_week02_03.controller;

import com.hh99_spring.re_week02_03.domain.Product;
import com.hh99_spring.re_week02_03.repository.ProductRepository;
import com.hh99_spring.re_week02_03.security.UserDetailsImpl;
import com.hh99_spring.re_week02_03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        return productService.getProducts(userId);
    }

}
