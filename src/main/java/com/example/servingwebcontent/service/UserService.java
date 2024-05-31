package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean updateUser(String id, User user);
    boolean deleteUser(String id);
    User findUserById(String id);
    List<User> findAllUsers();
    boolean checkUserExists(String id);
    boolean checkUserValid(User user);
}
