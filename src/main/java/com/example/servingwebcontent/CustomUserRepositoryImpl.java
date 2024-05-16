package com.example.servingwebcontent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean addUser(User user) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("addUser");
        spq.setParameter("p_userId",user.getUserId());
        spq.setParameter("p_username",user.getUsername());
        spq.setParameter("p_email",user.getEmail());
        spq.setParameter("p_password",user.getPassword());
        spq.setParameter("p_coverImage",user.getCoverImage());
        spq.setParameter("p_biography",user.getBiography());
        return spq.execute();
    }
}
