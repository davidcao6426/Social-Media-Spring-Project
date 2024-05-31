package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.service.UserService;
import com.example.servingwebcontent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public boolean addUser(@RequestBody User user) {
        System.out.println("新增：");
        return userService.addUser(user);
    }

    @PutMapping(path = "/user/{id}")
    public boolean updateUser(@PathVariable String id, @RequestBody User user) {
        System.out.println("更新：");
        return userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/user/{id}")
    public boolean delete(@PathVariable String id) {
        System.out.println("刪除：");
        return userService.deleteUser(id);
    }

    @GetMapping(path = "/user/{id}")
    public User findByUserId(@PathVariable String id) {
        System.out.println("查詢：");
        return userService.findUserById(id);
    }

    @GetMapping(path = "/users")
    public List<User> findAllUser() {
        System.out.println("查詢全部：");
        return userService.findAllUsers();
    }

    @PostMapping(path = "/login")
    public boolean login(@RequestBody User user) {
        System.out.println("登入：");
        return userService.checkUserValid(user);
    }
}