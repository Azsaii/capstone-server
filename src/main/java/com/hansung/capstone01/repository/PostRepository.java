package com.hansung.capstone01.repository;

import com.hansung.capstone01.dto.PostSummaryDTO;
import com.hansung.capstone01.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {
    Post findById(Long id);

    @Query("SELECT new com.hansung.capstone01.dto.PostSummaryDTO(p.id, p.userEmail, p.title) FROM Post p WHERE p.boardName = :boardName")
    List<PostSummaryDTO> findPostSummaryByBoardName(@Param("boardName") String boardName);
}