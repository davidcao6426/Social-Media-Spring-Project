package com.example.servingwebcontent.respository;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.util.EncryptUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId("789");
        user.setUsername("First");
        user.setEmail("davidcao@gmail.com");
        user.setPassword("testPassword");
        user.setCoverImage("123");
        user.setBiography("text_text");

        removeUser();
    }

    @AfterEach
    void tearDown() {
        removeUser();
    }

    private void removeUser(){
        User newUser = userRepository.findUserById(user.getUserId());
        if (newUser != null) {
            userRepository.deleteUser(newUser.getUserId());
        }
    }

    @Test
    void testCreateUser() {
        userRepository.addUser(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getCoverImage(),
                user.getBiography()
        );

        User newUser = userRepository.findUserById(user.getUserId());

        assertNotNull(newUser);
        assertEquals(user.getUserId(), newUser.getUserId());
        assertEquals(user.getUsername(), newUser.getUsername());
        assertEquals(user.getEmail(), newUser.getEmail());
        assertEquals(user.getPassword(), newUser.getPassword());
        assertEquals(user.getCoverImage(), newUser.getCoverImage());
        assertEquals(user.getBiography(), newUser.getBiography());
    }

    @Test
    void testCreateUserByEncryptPassword() {
        userRepository.addUser(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                EncryptUtil.encryptPassword(user.getPassword()),
                user.getCoverImage(),
                user.getBiography()
        );

        User newUser = userRepository.findUserById(user.getUserId());

        assertNotNull(newUser);
        assertEquals(user.getUserId(), newUser.getUserId());
        assertEquals(user.getUsername(), newUser.getUsername());
        assertEquals(user.getEmail(), newUser.getEmail());
        assertNotEquals(user.getPassword(), newUser.getPassword());
        assertTrue(EncryptUtil.decryptPassword(user.getPassword(), newUser.getPassword()));
        assertEquals(user.getCoverImage(), newUser.getCoverImage());
        assertEquals(user.getBiography(), newUser.getBiography());
    }

    @Test
    void testFindAllUser() {
        userRepository.addUser(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                EncryptUtil.encryptPassword(user.getPassword()),
                user.getCoverImage(),
                user.getBiography()
        );

        List<User> userList = userRepository.findAllUser();
        assertNotNull(userList);
        assertFalse(userList.isEmpty());
    }
}