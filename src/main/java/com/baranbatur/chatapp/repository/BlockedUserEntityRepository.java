package com.baranbatur.chatapp.repository;

import com.baranbatur.chatapp.entity.BlockedUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedUserEntityRepository extends JpaRepository<BlockedUserEntity, Long> {
}