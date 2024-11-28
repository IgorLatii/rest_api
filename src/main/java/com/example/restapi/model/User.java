package com.example.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users_adm")
public class User {
    @Id
    @Column(name = "name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
