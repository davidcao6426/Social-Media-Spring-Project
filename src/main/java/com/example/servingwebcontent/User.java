package com.example.servingwebcontent;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.Map;

@Entity // This tells Hibernate to make a table out of this class
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "addUser", procedureName = "addUser", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_userId", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_username", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_email", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_password", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coverImage", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_biography", type = String.class)
        }),
        @NamedStoredProcedureQuery(name = "findUserById", procedureName = "findUserById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_userId", type = String.class)
        })
})

@Table(name = "User")
public class User {
    @Id
    @Column(name = "userId")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "coverImage")
    private String coverImage;

    @Column(name = "biography")
    private String biography;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPassword() {
        return password;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getBiography() {
        return biography;
    }

//    @Procedure("addUser")
//    void addUser(String p_userId, String p_username, String p_email, String p_password, String p_coverImage, String p_biography) {
//
//    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}