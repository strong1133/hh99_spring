package com.hh99_spring.week03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductRequestDto {

    private String title;
    private String image;
    private String link;
    private int lprice;
}
