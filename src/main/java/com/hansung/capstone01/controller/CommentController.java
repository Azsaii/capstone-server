package com.hansung.capstone01.controller;

import com.hansung.capstone01.dto.CommentDTO;
import com.hansung.capstone01.service.CommentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000") //로컬에서 동작 시, 포트는 원하는 걸로 변경
//@CrossOrigin(origins = {"http://52.79.56.22", "http://brainbooster.kro.kr"}) 배포용으로 동작시 EC2 서버 주소, 원하는 도메인 주소로 변경 (단 React 배포 서버가 포트 80이어야 함)
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
