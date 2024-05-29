package com.hansung.capstone01.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "commentId")
    private String commentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "postId")
    private String postId;
}
