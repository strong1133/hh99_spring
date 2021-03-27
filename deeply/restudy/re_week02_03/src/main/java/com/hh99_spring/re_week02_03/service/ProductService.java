package com.hh99_spring.re_week02_03.service;

import com.hh99_spring.re_week02_03.domain.Product;
import com.hh99_spring.re_week02_03.dto.ProductMypriceRequestDto;
import com.hh99_spring.re_week02_03.dto.ProductRequestDto;
import com.hh99_spring.re_week02_03.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // user별 Product 조회
    public List<Product> getProducts(Long userId) {
        return productRepository.findAllByUserId(userId);
    }

    @Transactional //Product 생성
    public Product createProduct(ProductRequestDto productRequestDto, Long userid){
        Product product = new Product(productRequestDto, userid);
        productRepository.save(product);
        return  product;
    }

    @Transactional  // Product myprice 업데이트
    public Product updateProduct(Long id, ProductMypriceRequestDto mypriceRequestDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        int myPrice = mypriceRequestDto.getMyprice();
        product.updateMyprice(myPrice);
        return product;
    }

    // user 상관없이 전체 조회
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
