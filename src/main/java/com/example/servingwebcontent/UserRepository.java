package com.example.servingwebcontent;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    @Procedure("addUser")
    void addUser(String p_userId, String p_username, String p_email, String p_password, String p_coverImage, String p_biography);
    @Query(value = "CALL findUserById(:p_userId)", nativeQuery = true)
    User findUserById(String p_userId);
}