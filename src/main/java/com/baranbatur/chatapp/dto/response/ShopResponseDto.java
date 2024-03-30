package com.baranbatur.chatapp.dto.response;

import com.baranbatur.chatapp.util.TimeSlot;

import java.time.LocalTime;
import java.util.List;

public class ShopResponseDto {
    private long id;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private int timeSlotDuration;
    private int allocatedTimePerCustomer;
    private int numOfSeat;
    private List<TimeSlot> timeSlots;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
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

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
