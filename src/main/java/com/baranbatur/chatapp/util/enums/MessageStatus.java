package com.baranbatur.chatapp.util.enums;

public enum MessageStatus {
    READ(1), UNREAD(0);

    private final int value;

    MessageStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
