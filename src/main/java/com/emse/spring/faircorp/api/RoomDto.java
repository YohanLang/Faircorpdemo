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
    private Long buildingId;
    private String buildingName;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor=room.getFloor();
        this.currentTemperature=room.getCurrentTemperature();
        this.targetTemperature=room.getTargetTemperature();
        this.buildingId=room.getBuilding().getId();
        this.buildingName=room.getBuilding().getName();
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
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long roomId) {
        this.buildingId = buildingId;
    }
}