package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.User;

public interface UserService {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String id);
    User findUserById(String id);
}
