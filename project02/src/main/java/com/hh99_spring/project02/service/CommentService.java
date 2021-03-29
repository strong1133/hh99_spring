package com.hh99_spring.project02.service;

import com.hh99_spring.project02.domain.Article;
import com.hh99_spring.project02.domain.Comment;
import com.hh99_spring.project02.dto.CommentReqeustDto;
import com.hh99_spring.project02.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update_comment(Long id, CommentReqeustDto commentReqeustDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        comment.update_comment(commentReqeustDto);
        return comment.getId();

    }

    public Comment getComments(Long article_id){
        return commentRepository.findById(article_id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
    }

}
