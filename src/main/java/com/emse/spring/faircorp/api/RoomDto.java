package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowsStatus;

import java.util.Set;

public  class RoomDto {
    private Long id;
    private String name;
    private int floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Set<Long> windowId;
    private Set<Long> heaterId;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor=room.getFloor();
        this.currentTemperature=room.getCurrentTemperature();
        this.targetTemperature=room.getTargetTemperature();
        /*
        for (Heater h : room.getHeater()){
            this.heaterId.add(h.getId());
        }
        for (Window w : room.getWindow()){
            this.windowId.add(w.getId());
        }*/

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
/*
    public Set<Long> getHeaterId() {
        return heaterId;
    }

    public void setHeaterId(Set<Long> heater) {
        this.heaterId = heater;
    }

    public Set<Long> getWindowId() {
        return windowId;
    }

    public void setWindowId(Set<Long> window) {
        this.windowId = window;
    }*/
}