package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.Post;
import com.example.servingwebcontent.respository.PostRepository;
import com.example.servingwebcontent.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

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
        Post post = postRepository.findPostById(id);
        post.setComments(commentService.findCommentsByPostId(id));
        return post;
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAllPost();
    }
}
