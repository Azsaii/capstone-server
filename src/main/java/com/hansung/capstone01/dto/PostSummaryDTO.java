package com.hansung.capstone01.dto;

import lombok.Getter;

@Getter
public class PostSummaryDTO {
    private Long id;
    private String userEmail;
    private String title;
    public PostSummaryDTO(Long id, String userEmail, String title) {
        this.id = id;
        this.userEmail = userEmail;
        this.title = title;
    }

}
