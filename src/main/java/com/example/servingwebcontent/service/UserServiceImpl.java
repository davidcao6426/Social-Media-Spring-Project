package com.example.servingwebcontent.service;

import com.example.servingwebcontent.respository.UserRepository;
import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        User newUser = encryptPassword(user);
        try{
            userRepository.addUser(
                    newUser.getUserId(),
                    newUser.getUsername(),
                    newUser.getEmail(),
                    newUser.getPassword(),
                    newUser.getCoverImage(),
                    newUser.getBiography());
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        return false;
    }

    public User encryptPassword(User user){
        user.setPassword(EncryptUtil.encryptPassword(user.getPassword()));
        return user;
    }

    @Override
    public boolean updateUser(String id, User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUser();
    }

    @Override
    public boolean checkUserExists(String id) {
        return userRepository.findUserById(id) != null;
    }

    @Override
    public boolean checkUserValid(User user) {
        User foundUser = findUserById(user.getUserId());
        if(foundUser != null){
            return EncryptUtil.decryptPassword(user.getPassword(), foundUser.getPassword());
        }else{
            return false;
        }

    }


}
