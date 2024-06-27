package com.example.servingwebcontent.respository;

import com.example.servingwebcontent.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @Procedure("addPost")
    void addPost(String p_postId, String p_userId, String p_title, String p_content, Timestamp p_createAt);
    @Procedure("editPost")
    void editPost(String p_postId, String p_title, String p_content);
    @Procedure("deletePost")
    void deletePost(String p_postId);
    @Query(value = "CALL findPostById(:p_postId)", nativeQuery = true)
    Post findPostById(String p_postId);
    @Query(value = "CALL findAllPost", nativeQuery = true)
    List<Post> findAllPost();
}
