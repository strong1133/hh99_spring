package com.hh99_spring.week02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductRequestDto {

    private String title;
    private String link;
    private String image;
    private int lprice;
}
