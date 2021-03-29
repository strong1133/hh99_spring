package com.hh99_spring.project02.repository;

import com.hh99_spring.project02.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();
//    List<Comment> find(Long Article_id);
}
