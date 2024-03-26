package com.baranbatur.chatapp.repository;

import com.baranbatur.chatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User findUsernameV2(String username);

    Optional<User> findByEmail(String email);
}