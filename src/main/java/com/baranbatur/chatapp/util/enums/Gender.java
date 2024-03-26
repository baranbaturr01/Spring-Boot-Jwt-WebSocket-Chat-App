package com.baranbatur.chatapp.util.enums;

public enum Gender {
    MAN("Erkek"),
    WOMAN("Kadın");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
