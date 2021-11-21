package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Room;

public class RoomDto {
    private Long id;
    private Double currentTemperature;
    private int floor;
    private String name;
    private Double targetTemperature;
    private Long buildingId;
    private String buildingName;

    public RoomDto() {
    }


    public RoomDto(Room room) {
        this.id = room.getId();
        this.currentTemperature = room.getCurrentTemperature();
        this.floor = room.getFloor();
        this.name = room.getName();
        this.targetTemperature = room.getTargetTemperature();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}