package com.hansung.capstone01.controller;

import com.hansung.capstone01.DTO.CommentDTO;
import com.hansung.capstone01.service.CommentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/comments")
public class CommentController {

    private final CommentService CommentService;

    public CommentController(CommentService CommentService) {
        this.CommentService = CommentService;
    }

    @GetMapping
    public List<CommentDTO> getComments(@RequestParam(name = "postId") String postId){
        List<CommentDTO> Comments = CommentService.findByPostId(postId);
        return Comments;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@Valid @RequestBody CommentDTO newComment){
        CommentDTO savedComment = CommentService.saveComment(newComment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable(name = "commentId") String commentId){
        log.info("commentId = " + commentId);
        CommentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
