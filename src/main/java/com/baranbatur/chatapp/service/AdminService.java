package com.baranbatur.chatapp.service;


import com.baranbatur.chatapp.dto.request.ChairDto;
import com.baranbatur.chatapp.dto.request.RegisterShopDto;
import com.baranbatur.chatapp.entity.Chair;
import com.baranbatur.chatapp.entity.Shop;
import com.baranbatur.chatapp.repository.ChairRepository;
import com.baranbatur.chatapp.repository.ShopRepository;
import com.baranbatur.chatapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private UserRepository userRepository;
    private ShopRepository shopRepository;
    private final ChairRepository chairRepository;

    public AdminService(UserRepository userRepository, ShopRepository shopRepository,
                        ChairRepository chairRepository) {
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
        this.chairRepository = chairRepository;
    }

    public Shop createShop(RegisterShopDto registerShopDto) {
        Shop shop = new Shop();
        shop.setName(registerShopDto.getShopName());
        shop.setStarTime(registerShopDto.getShopOpenTime());
        shop.setEndTime(registerShopDto.getShopCloseTime());
        shop.setTimeSlotDuration(registerShopDto.getTimeSlotDuration());
        shop.setAllocatedTimePerCustomer(registerShopDto.getAllocatedTimePerCustomer());
        shop.setNumOfSeat(registerShopDto.getNumOfSeat());

        // ChairDto'dan Chair oluşturma
        List<Chair> chairs = new ArrayList<>();
        for (ChairDto chairDto : registerShopDto.getChairDtoList()) {
            Chair chair = new Chair();
            chair.setShop(shop);
            chair.setName(chairDto.getChairName());
            chair.setStartTime(chairDto.getStartTime());
            chair.setEndTime(chairDto.getEndTime());
            chairs.add(chair);
        }
        shop.setChairs(chairs);

        return this.shopRepository.save(shop);
    }
}
