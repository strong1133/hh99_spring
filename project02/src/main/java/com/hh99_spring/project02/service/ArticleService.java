package com.hh99_spring.project02.service;


import com.hh99_spring.project02.dto.AritcleRequestDto;
import com.hh99_spring.project02.domain.Article;
import com.hh99_spring.project02.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long update(Long id, AritcleRequestDto aritcleRequestDto){
        Article article = articleRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        article.update(aritcleRequestDto);
        return article.getId();
    }
}
