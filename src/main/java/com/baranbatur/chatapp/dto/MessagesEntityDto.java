package com.baranbatur.chatapp.dto;

import com.baranbatur.chatapp.util.enums.MessageStatus;

import java.io.Serializable;

public record MessagesEntityDto(Long id, UserEntityDto senderId, UserEntityDto receiverId, String message,
                                String sendDate, MessageStatus status) implements Serializable {
}