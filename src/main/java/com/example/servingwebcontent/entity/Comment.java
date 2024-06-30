package com.example.servingwebcontent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Comment")
public class Comment {
    @Id
    @Column(name = "commentId")
    private String commentId = UUID.randomUUID().toString();

//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "postId")
//    private Post post;
    @Column(name = "postId")
    private String postId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "content")
    private String content;

    @Column(name = "createAt")
    private Timestamp createAt = Timestamp.from(ZonedDateTime.now().toInstant());;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

//    public Post getPost() {
//        return post;
//    }

//    public void setPost(Post post) {
//        this.post = post;
//    }

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
}
