package com.baranbatur.chatapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blocked_users")
public class BlockedUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "blocked_user_id")
    private User blockedUserId;

    @Column(name = "blocked_date")
    private LocalDateTime blockedDate;

    public BlockedUserEntity(User userId, User blockedUserId, LocalDateTime blockedDate) {
        this.userId = userId;
        this.blockedUserId = blockedUserId;
        this.blockedDate = blockedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getBlockedUserId() {
        return blockedUserId;
    }

    public void setBlockedUserId(User blockedUserId) {
        this.blockedUserId = blockedUserId;
    }

    public LocalDateTime getBlockedDate() {
        return blockedDate;
    }

    public void setBlockedDate(LocalDateTime blockedDate) {
        this.blockedDate = blockedDate;
    }

    @Override
    public String toString() {
        return "BlockedUserEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", blockedUserId=" + blockedUserId +
                ", blockedDate=" + blockedDate +
                '}';
    }
}
