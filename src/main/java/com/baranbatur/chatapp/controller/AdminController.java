package com.baranbatur.chatapp.controller;

import com.baranbatur.chatapp.dto.request.RegisterShopDto;
import com.baranbatur.chatapp.dto.request.RegisterUserDto;
import com.baranbatur.chatapp.entity.Shop;
import com.baranbatur.chatapp.entity.User;
import com.baranbatur.chatapp.service.AdminService;
import com.baranbatur.chatapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create-shop")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Shop> createShop(@RequestBody RegisterShopDto shopDto) {
        Shop shop = adminService.createShop(shopDto);
        return ResponseEntity.ok(shop);
    }

}
