package com.baranbatur.chatapp.entity;

import com.baranbatur.chatapp.util.enums.MessageStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class MessagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User senderId;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiverId;
    @Column(name = "message")
    private String message;

    @Column(name = "send_date")
    private String sendDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MessageStatus status;

    public MessagesEntity(User senderId, User receiverId, String message, String sendDate, MessageStatus status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.sendDate = sendDate;
        this.status = status;
    }

    public MessagesEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    public User getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(User receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}

