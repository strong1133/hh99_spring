package com.hh99_spring.week04.service;

import com.hh99_spring.week04.domain.Product;
import com.hh99_spring.week04.domain.ProductMypriceRequestDto;
import com.hh99_spring.week04.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto mypriceRequestDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        product.update(mypriceRequestDto);
        return product.getId();
    }
}
