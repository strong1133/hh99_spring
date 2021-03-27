package com.hh99_spring.project02.repository;

import com.hh99_spring.project02.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByModifiedAtDesc();
}
