package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "TESTUSERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;  // This will be stored as a hashed password

    @Column(name = "user_perms", nullable = false)
    private Integer user_perms;

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getUser_perms() { return user_perms; }
    public void setUser_perms(Integer user_perms) { this.user_perms = user_perms; }

}
