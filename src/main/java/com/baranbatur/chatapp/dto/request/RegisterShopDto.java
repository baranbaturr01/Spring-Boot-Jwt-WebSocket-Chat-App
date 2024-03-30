package com.baranbatur.chatapp.dto.request;

import com.baranbatur.chatapp.entity.Chair;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RegisterShopDto {

    private String shopName;
    private LocalTime shopOpenTime;
    private LocalTime shopCloseTime;
    private int timeSlotDuration;
    private int allocatedTimePerCustomer;
    private int numOfSeat;
    private List<ChairDto> chairs;

    public RegisterShopDto(String shopName, LocalTime shopOpenTime, LocalTime shopCloseTime, int timeSlotDuration, int allocatedTimePerCustomer, int numOfSeat, List<ChairDto> chairs) {
        this.shopName = shopName;
        this.shopOpenTime = shopOpenTime;
        this.shopCloseTime = shopCloseTime;
        this.timeSlotDuration = timeSlotDuration;
        this.allocatedTimePerCustomer = allocatedTimePerCustomer;
        this.numOfSeat = numOfSeat;
        this.chairs = chairs;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public LocalTime getShopOpenTime() {
        return shopOpenTime;
    }

    public void setShopOpenTime(LocalTime shopOpenTime) {
        this.shopOpenTime = shopOpenTime;
    }

    public LocalTime getShopCloseTime() {
        return shopCloseTime;
    }

    public void setShopCloseTime(LocalTime shopCloseTime) {
        this.shopCloseTime = shopCloseTime;
    }

    public int getTimeSlotDuration() {
        return timeSlotDuration;
    }

    public void setTimeSlotDuration(int timeSlotDuration) {
        this.timeSlotDuration = timeSlotDuration;
    }

    public int getAllocatedTimePerCustomer() {
        return allocatedTimePerCustomer;
    }

    public void setAllocatedTimePerCustomer(int allocatedTimePerCustomer) {
        this.allocatedTimePerCustomer = allocatedTimePerCustomer;
    }

    public int getNumOfSeat() {
        return numOfSeat;
    }

    public void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }

    public List<ChairDto> getChairDtoList() {
        return chairs;
    }

    public void setChairDtoList(List<ChairDto> chairs) {
        this.chairs = chairs;
    }
}
