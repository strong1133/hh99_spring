package com.hh99_spring.week01.domain;

import com.hh99_spring.week01.dto.ProductRequestDto;
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

    public Product(ProductRequestDto productRequestDto){
        this.title = productRequestDto.getTitle();
        this.image = productRequestDto.getImage();
        this.link = productRequestDto.getLink();
        this.lprice = productRequestDto.getLprice();
        this.myprice = 0;
    }

    public void updateMyprice(int myPrice) {
        this.myprice=myPrice;
    }
}
