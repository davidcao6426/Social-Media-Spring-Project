package com.example.servingwebcontent.respository;

import com.example.servingwebcontent.entity.Post;
import com.example.servingwebcontent.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<User, Integer> {
    @Procedure("addPost")
    void addPost(String p_postId, String p_userId, String p_content);
    @Procedure("editPost")
    void editPost(String p_postId, String p_content);
    @Procedure("deletePost")
    void editPost(String p_postId);
    @Query(value = "CALL findAllPost", nativeQuery = true)
    List<Post> findAllPost(String p_userId);
}
