package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.Comment;

import java.util.List;

public interface CommentService {
    boolean addComment(Comment comment);
    List<Comment> findCommentsByPostId(String postId);
}
