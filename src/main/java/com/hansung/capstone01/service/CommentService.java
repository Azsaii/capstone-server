package com.hansung.capstone01.service;

import com.hansung.capstone01.DTO.CommentDTO;
import com.hansung.capstone01.entity.Comment;
import com.hansung.capstone01.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository CommentRepository;

    public CommentService(CommentRepository CommentRepository) {
        this.CommentRepository = CommentRepository;
    }

    public List<CommentDTO> findByPostId(String postId) {
        List<Comment> Comments = CommentRepository.findByPostId(postId);

        // Comment 엔티티를 CommentDTO로 변환
        List<CommentDTO> CommentDTOs = Comments.stream()
                .map(Comment -> new CommentDTO(Comment.getCommentId(), Comment.getComment(), Comment.getUserEmail(), Comment.getPostId()))
                .collect(Collectors.toList());

        return CommentDTOs;
    }

    public CommentDTO saveComment(CommentDTO newComment) {
        // DTO를 엔티티로 변환
        Comment Comment = new Comment(newComment.getCommentId(), newComment.getComment(), newComment.getUserEmail(), newComment.getPostId());

        // 저장하고 결과를 엔티티로 받음
        Comment savedComment = CommentRepository.save(Comment);

        // 저장된 엔티티를 DTO로 변환
        CommentDTO savedCommentDTO = new CommentDTO(savedComment.getCommentId(), savedComment.getComment(), savedComment.getUserEmail(), savedComment.getPostId());

        return savedCommentDTO;
    }

    public void deleteComment(String CommentId) {
        CommentRepository.deleteById(CommentId);
    }
}
