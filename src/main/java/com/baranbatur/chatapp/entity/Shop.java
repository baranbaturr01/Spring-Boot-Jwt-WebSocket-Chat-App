package com.baranbatur.chatapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "start_time")
    private LocalTime starTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "time_slot_duration")
    // in minutes. For example, 30 minutes. Default is 15 minutes.(Kaç dk da bir müşteri alınacak)
    private int timeSlotDuration;

    @Column(name = "allocated_time_per_customer")
    // Müşteri başona ayırlan süre
    private int allocatedTimePerCustomer;

    @Column(name = "numOfSeat")
    private int numOfSeat;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Chair> chairs;

    public Shop() {
    }

    public Shop(long id, String name, LocalTime starTime, LocalTime endTime, int timeSlotDuration, int allocatedTimePerCustomer, int numOfSeat, List<Chair> chairs) {
        this.id = id;
        this.name = name;
        this.starTime = starTime;
        this.endTime = endTime;
        this.timeSlotDuration = timeSlotDuration;
        this.allocatedTimePerCustomer = allocatedTimePerCustomer;
        this.numOfSeat = numOfSeat;
        this.chairs = chairs;
    }

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

    public LocalTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalTime starTime) {
        this.starTime = starTime;
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

    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }
}
