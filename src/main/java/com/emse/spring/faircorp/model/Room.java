package com.emse.spring.faircorp.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String name;

    @Column(name = "CURRENTTEMPERATURE")
    private Double currentTemperature;

    @Column(name = "TARGETTEMPERATURE")
    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heater;

    @OneToMany(mappedBy = "room")
    private Set<Window> window;

    @ManyToOne
    private Building building;

    public Room() {
    }

    public Room(int floor, String name, Building building) {
        this.floor = floor;
        this.name = name;
        this.building = building;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Set<Heater> getHeater() {
        return heater;
    }

    public void setHeater(Set<Heater> heater) {
        this.heater = heater;
    }

    public Set<Window> getWindow() {
        return window;
    }

    public void setWindow(Set<Window> window) {
        this.window = window;
    }

    public Building getBuilding() {
        return this.building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}