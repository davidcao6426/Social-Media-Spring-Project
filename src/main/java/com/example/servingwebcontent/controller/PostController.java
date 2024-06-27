package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.entity.Post;
import com.example.servingwebcontent.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(path = "/post/{id}")
    public Post findPostById(@PathVariable String id){
        return postService.findPostById(id);
    }

    @GetMapping(path = "/posts")
    public List<Post> findAllPost(){
        return postService.findAllPosts();
    }

    @PostMapping(path = "/post")
    public boolean addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @PutMapping(path = "/post/{id}")
    public boolean addPost(@PathVariable String id, @RequestBody Post post){
        return postService.updatePost(id, post);
    }

    @DeleteMapping(path = "/post/{id}")
    public boolean deletePost(@PathVariable String id){
        return postService.deletePost(id);
    }
}
