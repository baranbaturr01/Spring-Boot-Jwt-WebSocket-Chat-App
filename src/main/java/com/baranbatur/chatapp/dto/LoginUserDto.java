package com.baranbatur.chatapp.dto;

public class LoginUserDto {

    private String username;
    private String password;

    public LoginUserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return username;
    }

    public void setEmail(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
