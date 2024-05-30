package com.hansung.capstone01.service;

import com.hansung.capstone01.dto.PostDTO;
import com.hansung.capstone01.dto.PostSummaryDTO;
import com.hansung.capstone01.entity.Post;
import com.hansung.capstone01.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDTO findById(Long id){
        Post post = postRepository.findById(id);
        PostDTO postDTO = new PostDTO(post.getId(), post.getPostId(), post.getBoardName(), post.getUserEmail(), post.getTitle(), post.getBody());
        return postDTO;
    }

    public List<PostSummaryDTO> findByBoardName(String boardName) {
        List<PostSummaryDTO> postSummaryDTOs = postRepository.findPostSummaryByBoardName(boardName);
        return postSummaryDTOs;
    }

    public PostDTO savePost(PostDTO newPost) {
        // DTO를 엔티티로 변환
        Post post = new Post(newPost.getId(), newPost.getPostId(), newPost.getBoardName(), newPost.getUserEmail(), newPost.getTitle(), newPost.getBody());

        // 저장하고 결과를 엔티티로 받음
        Post savedPost = postRepository.save(post);

        // 저장된 엔티티를 DTO로 변환
        PostDTO savedPostDTO = new PostDTO(savedPost.getId(), savedPost.getPostId(), savedPost.getBoardName(), savedPost.getUserEmail(), savedPost.getTitle(), savedPost.getBody());

        return savedPostDTO;
    }

    public void deletePost(String postId) {
        postRepository.deleteById(postId);
    }
}
