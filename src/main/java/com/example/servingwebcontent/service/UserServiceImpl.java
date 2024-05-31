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
        try{
            userRepository.addUser(
                    user.getUserId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getCoverImage(),
                    user.getBiography());
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
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
        return List.of();
    }

    @Override
    public boolean checkUserExists(String id) {
        return userRepository.findUserById(id) != null;
    }

    @Override
    public boolean checkUserValid(User user) {
        return EncryptUtil.decryptPassword(user.getPassword(), findUserById(user.getUserId()).getPassword());
    }


}
