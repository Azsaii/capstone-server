package com.hansung.capstone01.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @Size(min=1, max=5000, message = "Body must be between 1 and 5000 chars")
    @Column(name = "body")
    private String body;

    @Column(name = "type")
    private String type;
}
