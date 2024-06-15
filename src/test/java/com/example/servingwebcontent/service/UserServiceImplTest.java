package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.respository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @MockBean
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    public void testAddEmptyUserShouldThrowException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {userServiceImpl.addUser(user);});
    }

    @Test
    public void testAddUserHasIllegalUserIdShouldThrowException(){
        user.setUserId("1234567890123456");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {userServiceImpl.addUser(user);});
    }

    @Test
    public void testAddUserHasIllegalUserNameShouldThrowException(){
        user.setUsername("123456789012345678901");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {userServiceImpl.addUser(user);});
    }

    @Test
    public void testUserPasswordShouldEncrypt(){
        user.setUserId("123");
        user.setBiography("testBiography");
        user.setEmail("test@gmail.com");
        user.setPassword("password");
        assertTrue(userServiceImpl.addUser(user));
        assertNotEquals(user.getPassword(), "password");
    }
}