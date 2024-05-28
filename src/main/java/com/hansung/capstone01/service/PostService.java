package com.hansung.capstone01.service;

import com.hansung.capstone01.DTO.PostDTO;
import com.hansung.capstone01.domain.ImageUpload;
import com.hansung.capstone01.domain.Post;
import com.hansung.capstone01.repository.ImageUploadRepository;
import com.hansung.capstone01.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private ImageUploadRepository imageRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDTO> findByBoardName(String boardName) {
        List<Post> posts = postRepository.findByBoardName(boardName);

        // Post 엔티티를 PostDTO로 변환
        List<PostDTO> postDTOs = posts.stream()
                .map(post -> new PostDTO(post.getPostId(), post.getBoardName(), post.getUserEmail(), post.getTitle(), post.getBody(), post.getType()))
                .collect(Collectors.toList());

        return postDTOs;
    }

    public PostDTO savePost(PostDTO newPost) {
        // DTO를 엔티티로 변환
        Post post = new Post(newPost.getPostId(), newPost.getBoardName(), newPost.getUserEmail(), newPost.getTitle(), newPost.getBody(), newPost.getType());

        // 저장하고 결과를 엔티티로 받음
        Post savedPost = postRepository.save(post);

        // 저장된 엔티티를 DTO로 변환
        PostDTO savedPostDTO = new PostDTO(savedPost.getPostId(), savedPost.getBoardName(), savedPost.getUserEmail(), savedPost.getTitle(), savedPost.getBody(), savedPost.getType());

        return savedPostDTO;
    }

    public ImageUpload saveImage(String fileName, String fileUrl) {
        ImageUpload imageUpload = new ImageUpload();
        imageUpload.setFileName(fileName);
        imageUpload.setFileUrl(fileUrl);
        imageUpload.setUploadedAt(LocalDateTime.now());
        return imageRepository.save(imageUpload);
    }

    public void deletePost(String postId) {
        postRepository.deleteById(postId);
    }
}
