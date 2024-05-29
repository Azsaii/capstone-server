package com.hansung.capstone01.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long id;
    private String commentId;
    private String comment;
    private String userEmail;
    private String postId;
}
