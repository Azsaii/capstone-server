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
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "postId")
    private String postId;

    @Column(name = "boardName")
    private String boardName;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "type")
    private String type;
}
