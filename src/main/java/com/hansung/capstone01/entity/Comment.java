package com.hansung.capstone01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "commentId")
    private String commentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "postId")
    private String postId;
}
