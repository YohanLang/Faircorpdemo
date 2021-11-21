package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

public class HeaterDto {
    private Long id;
    private String name;
    private HeaterStatus Status;
    private Long roomId;
    private String roomName;
    private Long power;

    public HeaterDto() {

    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.Status = heater.getStatus();
        this.roomId = heater.getRoom().getId();
        this.roomName = heater.getRoom().getName();
        this.power = heater.getPower();
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

    public HeaterStatus getStatus() {
        return Status;
    }

    public void setStatus(HeaterStatus Status) {
        this.Status = Status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getPower() {
        return power;

    }

    public void setPower(Long power) {
        this.power = power;
    }
}
