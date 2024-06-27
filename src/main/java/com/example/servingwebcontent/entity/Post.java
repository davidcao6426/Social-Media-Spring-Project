package com.example.servingwebcontent.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Post")
public class Post {
    @Id
    @Column(name = "postId")
    private String postId = UUID.randomUUID().toString();

    @Column(name = "userId")
    private String userId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "createAt")
    private Timestamp createAt = Timestamp.from(ZonedDateTime.now().toInstant());;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
