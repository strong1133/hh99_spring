package com.hh99_spring.re_week02_03.domain;

import com.hh99_spring.re_week02_03.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private int lprice;
    @Column(nullable = false)
    private int myprice;

    @Column(nullable = false)
    private Long userId;

    public Product(ProductRequestDto requestDto, Long userId) {
        // 관심상품을 등록한 회원 Id 저장
        this.userId = userId;
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }

    public void updateMyprice(int myPrice) {
        this.myprice=myPrice;
    }
}
