package com.example.demo;

public class UserRegistrationRequest {
    private String username;
    private String email;
    private String password;
    private String fname;
    private String lname;

    private Integer user_perms;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    public Integer getUser_perms() { return user_perms; }
    public void setUser_perms(Integer user_perms){ this.user_perms = user_perms; }
}
