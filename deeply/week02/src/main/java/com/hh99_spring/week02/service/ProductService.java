package com.hh99_spring.week02.service;




import com.hh99_spring.week02.domain.Product;
import com.hh99_spring.week02.dto.ProductMypriceRequestDto;
import com.hh99_spring.week02.dto.ProductRequestDto;
import com.hh99_spring.week02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    // 멤버 변수 선언
    private final ProductRepository productRepository;

    // 생성자: ProductService() 가 생성될 때 호출됨
    @Autowired
    public ProductService(ProductRepository productRepository) {
        // 멤버 변수 생성
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(Long userId) {
        return productRepository.findAllByUserId(userId);
    }


    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product createProduct(ProductRequestDto requestDto, Long userId ) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        int myPrice = requestDto.getMyprice();
        product.updateMyprice(myPrice);
        return product;
    }

    // 모든 상품 조회 (관리자용)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}