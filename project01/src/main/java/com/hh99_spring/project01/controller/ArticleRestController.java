package com.hh99_spring.project01.controller;

import com.hh99_spring.project01.domain.AritcleRequestDto;
import com.hh99_spring.project01.domain.Article;
import com.hh99_spring.project01.domain.ArticleRepository;
import com.hh99_spring.project01.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleRestController {
    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    @GetMapping("/api/articles")
    public List<Article> getArticle (){
        return articleRepository.findAll();
    }

    @PostMapping("/api/articles")
    public Article createArticle (@RequestBody AritcleRequestDto aritcleRequestDto){
        Article article = new Article(aritcleRequestDto);
        return articleRepository.save(article);
    }

    @PutMapping("/api/articles/{id}")
    public Long updateArticle (@PathVariable Long id, @RequestBody AritcleRequestDto aritcleRequestDto){
        return articleService.update(id, aritcleRequestDto);
    }

    @DeleteMapping("/api/articles/{id}")
    public Long deleteArticle (@PathVariable Long id){
        articleRepository.deleteById(id);
        return id;
    }


}
