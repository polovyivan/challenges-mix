package com.ivan.polovyi.challenges.security.dto;


/*
Defines what user sends for authentication
 */
public class AuthenticationRequest {

    private String username;
    private String password;

    // needed for serialization
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
