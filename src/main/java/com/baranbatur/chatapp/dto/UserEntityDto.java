package com.baranbatur.chatapp.dto;

import java.io.Serializable;
import java.util.Date;

public record UserEntityDto(Long id, String username, String password, String firstName, String lastName, String email,
                            String phone, boolean gender, Date birthDate, Date createdAt) implements Serializable {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "phone = " + phone + ", " +
                "gender = " + gender + ", " +
                "birthDate = " + birthDate + ", " +
                "createdAt = " + createdAt + ")";
    }
}