package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.Post;
import com.example.servingwebcontent.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public boolean addPost(Post post) {
        try{
            postRepository.addPost(
                    post.getPostId(),
                    post.getUserId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getCreateAt()
            );
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean updatePost(String id, Post post) {
        try{
            postRepository.editPost(
                    post.getPostId(),
                    post.getTitle(),
                    post.getContent()
            );
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean deletePost(String id) {
        try{
            postRepository.deletePost(id);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Post findPostById(String id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAllPost();
    }
}
