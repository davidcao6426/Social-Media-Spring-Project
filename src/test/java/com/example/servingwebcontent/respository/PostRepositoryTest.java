package com.example.servingwebcontent.respository;

import com.example.servingwebcontent.config.SecurityConfig;
import com.example.servingwebcontent.entity.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setTitle("testTitle");
        post.setContent("testContent");
        post.setUserId("789");
    }

    @AfterEach
    void tearDown(){
        removePost();
    }

    private void removePost(){
        Post newPost = postRepository.findPostById(post.getPostId());
        if (newPost != null) {
            postRepository.deletePost(post.getPostId());
        }
    }

    @Test
    void testCreatePost() {
        postRepository.addPost(
                post.getPostId(),
                post.getUserId(),
                post.getTitle(),
                post.getContent(),
                post.getCreateAt()
        );

        Post newPost = postRepository.findPostById(post.getPostId());

        assertNotNull(newPost);
        assertEquals(post.getPostId(), newPost.getPostId());
        assertEquals(post.getUserId(), newPost.getUserId());
        assertEquals(post.getContent(), newPost.getContent());
    }

    @Test
    void testEditPost() {
        postRepository.addPost(
                post.getPostId(),
                post.getUserId(),
                post.getTitle(),
                post.getContent(),
                post.getCreateAt()
        );

        Post newPost = postRepository.findPostById(post.getPostId());

        assertNotNull(newPost);
        assertEquals(post.getPostId(), newPost.getPostId());
        assertEquals(post.getUserId(), newPost.getUserId());
        assertEquals(post.getContent(), newPost.getContent());

        post.setContent("editPost");

        postRepository.editPost(
                post.getPostId(),
                post.getTitle(),
                post.getContent()
        );

        Post newPost2 = postRepository.findPostById(post.getPostId());

        assertNotNull(newPost2);
        assertEquals(post.getPostId(), newPost2.getPostId());
        assertEquals(post.getUserId(), newPost2.getUserId());
        assertEquals(post.getContent(), newPost2.getContent());
    }

    @Test
    void testFindAllPost() {
        postRepository.addPost(
                post.getPostId(),
                post.getUserId(),
                post.getTitle(),
                post.getContent(),
                post.getCreateAt()
        );

        List<Post> postList = postRepository.findAllPost();

        assertNotNull(postList);
        assertFalse(postList.isEmpty());
    }
}