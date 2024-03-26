package com.baranbatur.chatapp.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record BlockedUserEntityDto(Long id, UserEntityDto userId, UserEntityDto blockedUserId,
                                   LocalDateTime blockedDate) implements Serializable {
}