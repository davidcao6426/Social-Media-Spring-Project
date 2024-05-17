package com.example.servingwebcontent.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Post")
public class Post {
    @Id
    @Column(name = "postId")
    private String postId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "content")
    private String content;

    @Column(name = "createAt")
    private ZonedDateTime createAt;
}
