package com.hh99_spring.project02.controller;

import com.hh99_spring.project02.domain.Comment;
import com.hh99_spring.project02.dto.CommentReqeustDto;
import com.hh99_spring.project02.repository.CommentRepository;
import com.hh99_spring.project02.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("/api/comments")
    public List<Comment> getComment(){
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }


    @GetMapping("/api/comment/{id}")
    public Comment getComments(Long article_id){
        return commentRepository.findById(article_id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
    }


    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentReqeustDto commentReqeustDto){
        Comment comment = new Comment(commentReqeustDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentReqeustDto commentReqeustDto){
        return commentService.update_comment(id, commentReqeustDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
