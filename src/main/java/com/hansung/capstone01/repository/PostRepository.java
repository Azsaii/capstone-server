package com.hansung.capstone01.repository;

import com.hansung.capstone01.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {
    Page<Post> findByBoardName(String boardName, Pageable pageable);
}