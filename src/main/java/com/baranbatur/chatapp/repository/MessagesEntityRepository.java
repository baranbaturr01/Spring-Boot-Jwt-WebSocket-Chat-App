package com.baranbatur.chatapp.repository;

import com.baranbatur.chatapp.entity.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesEntityRepository extends JpaRepository<MessagesEntity, Long> {
}