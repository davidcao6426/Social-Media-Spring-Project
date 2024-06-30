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
        try{
            commentRepository.addComment(
                    comment.getCommentId(),
                    comment.getPostId(),
                    comment.getUserId(),
                    comment.getContent(),
                    comment.getCreateAt()
            );
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<Comment> findCommentsByPostId(String postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}
