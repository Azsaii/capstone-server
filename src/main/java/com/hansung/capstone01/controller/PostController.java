package com.hansung.capstone01.controller;

import com.hansung.capstone01.dto.PostDTO;
import com.hansung.capstone01.dto.PostSummaryDTO;
import com.hansung.capstone01.service.PostService;
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
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> getPosts(@RequestParam(name = "id", required = false) Long id,
                                      @RequestParam(name = "boardName", required = false) String boardName) {
        if (id != null) {
            PostDTO posts = postService.findById(id);
            return ResponseEntity.ok(posts);
        } else if (boardName != null) {
            List<PostSummaryDTO> postSummaryDTOs = postService.findByBoardName(boardName);
            return ResponseEntity.ok(postSummaryDTOs);
        }
        return ResponseEntity.badRequest().body("id 또는 boardName 중 하나는 반드시 제공되어야 합니다.");
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO newPost){
        PostDTO savedPost = postService.savePost(newPost);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable(name = "postId") String postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
