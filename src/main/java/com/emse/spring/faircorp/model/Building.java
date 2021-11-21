package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(name = "OUTSIDETEMPERATURE")
    private Double outsideTemperature;

    @OneToMany(mappedBy = "building")
    private Set<Room> room;

    public Building() {
    }

    public Building(String name, double outsideTemperature) {
        this.name = name;
        this.outsideTemperature = outsideTemperature;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRoom() {
        return room;
    }

    public void setRoom(Set<Room> room) {
        this.room = room;
    }

}
