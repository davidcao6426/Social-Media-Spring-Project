package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.Post;

import java.util.List;

public interface PostService {
    boolean addPost(Post post);
    boolean updatePost(String id, Post post);
    boolean deletePost(String id);
    Post findPostById(String id);
    List<Post> findAllPosts();
}
