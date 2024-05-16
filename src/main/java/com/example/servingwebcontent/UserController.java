package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public boolean addUser(@RequestBody User user) {
        System.out.println("新增：");
        return userService.addUser(user);
    }

    @PutMapping(path = "/user")
    public boolean updateUser(@RequestBody User user) {
        System.out.println("更新：");
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/user")
    public boolean delete(@RequestParam(value = "id", required = true) String Id) {
        System.out.println("刪除：");
        return userService.deleteUser(Id);
    }

    @GetMapping(path = "/user")
    public User findByUserId(@RequestParam(value = "id", required = true) String Id) {
        System.out.println("查詢：");
        return userService.findUserById(Id);
    }
}