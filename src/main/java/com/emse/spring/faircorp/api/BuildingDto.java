package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowsStatus;

import java.util.Set;

public  class BuildingDto {
    private Long id;
    private String name;

    private Double outsideTemperature;
    private Set<Long> roomId;


    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();

        this.outsideTemperature=building.getOutsideTemperature();

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

    public double getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(double outsideTemperature) {
        this.outsideTemperature= outsideTemperature;
    }}
