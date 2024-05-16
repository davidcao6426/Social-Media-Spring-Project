package com.example.servingwebcontent;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String id);
    List<User> findAll();
}
