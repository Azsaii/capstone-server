package com.hansung.capstone01.repository;

import com.hansung.capstone01.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findByBoardName(String boardName);
}