package com.example.servingwebcontent.respository;

import com.example.servingwebcontent.entity.Comment;
import com.example.servingwebcontent.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    Comment comment;

    @BeforeEach
    void setUp() {
        comment = new Comment();
        comment.setContent("testContent");
        comment.setUserId("789");
        comment.setPostId("8e1b8cd4-ce15-4692-9c00-5f7211d22bf9");
    }

    @Test
    void testCreatePost() {
        commentRepository.addComment(
                comment.getCommentId(),
                comment.getPostId(),
                comment.getUserId(),
                comment.getContent(),
                comment.getCreateAt()
        );

        List<Comment> commentList = commentRepository.findCommentsByPostId(comment.getPostId());

        assertNotNull(commentList);
        assertFalse(commentList.isEmpty());

        int lastIndex = commentList.size() - 1;
        assertEquals(commentList.get(lastIndex).getCommentId(), comment.getCommentId());
        assertEquals(commentList.get(lastIndex).getPostId(), comment.getPostId());
        assertEquals(commentList.get(lastIndex).getUserId(), comment.getUserId());
        assertEquals(commentList.get(lastIndex).getContent(), comment.getContent());
    }
}