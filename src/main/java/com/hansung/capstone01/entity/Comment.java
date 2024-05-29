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
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "commentId")
    private String commentId;

    @Size(min=1, max=500, message = "Comment must be between 1 and 500 chars")
    @Column(name = "comment")
    private String comment;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "postId")
    private String postId;
}
