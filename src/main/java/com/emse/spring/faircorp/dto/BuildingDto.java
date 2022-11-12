package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Building;


public class BuildingDto {
    private Long id;
    private String name;
    private Double outsideTemperature;


    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.outsideTemperature = building.getOutsideTemperature();
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setOutsideTemperature(Double outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }
    public Double getOutsideTemperature() {
        return outsideTemperature;
    }


}
