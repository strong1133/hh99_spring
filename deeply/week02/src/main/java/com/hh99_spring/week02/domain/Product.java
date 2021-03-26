package com.hh99_spring.week02.domain;

import com.hh99_spring.week02.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
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

    // 관심 상품 생성 시 이용합니다.
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
