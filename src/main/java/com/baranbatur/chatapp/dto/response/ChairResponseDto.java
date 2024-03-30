package com.baranbatur.chatapp.dto.response;

import com.baranbatur.chatapp.util.TimeSlot;

import java.util.List;

public class ChairResponseDto {
    private long id;
    private String name;
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

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
