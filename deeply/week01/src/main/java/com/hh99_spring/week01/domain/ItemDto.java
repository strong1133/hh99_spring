package com.hh99_spring.week01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.security.SecureRandom;

@Getter
@NoArgsConstructor
public class ItemDto {

    private String title;
    private String image;
    private String link;
    private int lprice;

    public ItemDto(JSONObject itemJson){
        this.title = itemJson.getString("title");
        this.image = itemJson.getString("image");
        this.link = itemJson.getString("link");
        this.lprice = itemJson.getInt("lprice");
    }
}
