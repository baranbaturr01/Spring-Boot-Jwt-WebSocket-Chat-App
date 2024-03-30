package com.baranbatur.chatapp.controller;

import com.baranbatur.chatapp.dto.request.ChairDto;
import com.baranbatur.chatapp.entity.Shop;
import com.baranbatur.chatapp.entity.User;
import com.baranbatur.chatapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/get-shop-list")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Shop>> getAllList() {
        return ResponseEntity.ok(userService.getAllShopList());

    }

    @GetMapping("/get-shop-chair-detail-by-chair-id/{chairId}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<ChairDto> getShopChairDetailByChairId(@PathVariable long chairId) {

        return ResponseEntity.ok(userService.getShopChairDetailByChairId(chairId));

    }

}
