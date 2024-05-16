package com.example.servingwebcontent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Test
    void createUserTest() {
        User n = new User();
        String userId="0929395679";
        String username="First";
        String email="davidcao6426@gmail.com";
        String password="hl654d93";
        String coverImage="123";
        String biography="text_text";
        n.setUserId(userId);
        n.setUsername(username);
        n.setEmail(email);
        n.setPassword(password);
        n.setCoverImage(coverImage);
        n.setBiography(biography);
        userRepository.save(n);
    }

    @Test
    void createUserByStoredProcedureTest() {
        User n = new User();
        String userId="789";
        String username="First";
        String email="davidcao@gmail.com";
        String password="hl654d93";
        String coverImage="123";
        String biography="text_text";

        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("addUser");
        spq.setParameter("p_userId",userId);
        spq.setParameter("p_username",username);
        spq.setParameter("p_email",email);
        spq.setParameter("p_password",password);
        spq.setParameter("p_coverImage",coverImage);
        spq.setParameter("p_biography",biography);
        spq.execute();
    }

}