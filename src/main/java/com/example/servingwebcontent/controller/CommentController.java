package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.entity.Comment;
import com.example.servingwebcontent.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/comment")
    public boolean addPost(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}
