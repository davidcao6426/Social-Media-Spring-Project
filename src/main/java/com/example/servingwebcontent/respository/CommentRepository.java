package com.example.servingwebcontent.respository;

import com.example.servingwebcontent.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    @Query(value = "CALL findCommentsByPostId(:p_postId)", nativeQuery = true)
    List<Comment> findCommentsByPostId(String p_postId);
    @Procedure("addComment")
    void addComment(String p_commentId, String p_postId, String p_userId, String p_content, Timestamp p_createAt);
}
