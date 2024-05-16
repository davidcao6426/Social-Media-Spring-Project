package com.example.servingwebcontent;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(String id);
    User findUserById(String id);
}
