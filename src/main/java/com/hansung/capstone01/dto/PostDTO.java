package com.hansung.capstone01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;
    private String postId;
    private String boardName;
    private String userEmail;
    private String title;
    private String body;
}

