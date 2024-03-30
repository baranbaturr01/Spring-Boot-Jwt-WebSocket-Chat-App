package com.baranbatur.chatapp.dto.request;

import com.baranbatur.chatapp.util.TimeSlot;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ChairDto {

    private long id;
    private String chairName;
    private LocalTime startTime;
    private LocalTime endTime;

    private List<TimeSlot> availabilityIntervals;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChairName() {
        return chairName;
    }

    public void setChairName(String chairName) {
        this.chairName = chairName;
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

    public List<TimeSlot> getAvailabilityIntervals() {
        return availabilityIntervals;
    }

    public void setAvailabilityIntervals(List<TimeSlot> availabilityIntervals) {
        this.availabilityIntervals = availabilityIntervals;
    }
}
