package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.Comment;
import com.example.servingwebcontent.respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public boolean addComment(Comment comment) {
        return false;
    }

    @Override
    public List<Comment> findCommentsByPostId(String postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}
