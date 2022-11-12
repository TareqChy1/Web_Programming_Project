package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Room;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomCmdDto {
    private Long id;
    private String name;
    private Integer floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private Set<HeaterDto> heaters;
    private Set<WindowDto> windows;
    private Long buildingId;
    private String buildingName;

    public RoomCmdDto() {
    }

    public RoomCmdDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
        if(room.getHeaters() != null) {this.heaters = room.getHeaters().stream().map(HeaterDto::new).collect(Collectors.toSet());}
        if(room.getWindows() != null) {this.windows = room.getWindows().stream().map(WindowDto::new).collect(Collectors.toSet());}
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


    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    public Integer getFloor() {
        return floor;
    }


    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
    public Double getCurrentTemperature() {
        return currentTemperature;
    }


    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
    public Double getTargetTemperature() {
        return targetTemperature;
    }


    public void setHeaters(Set<HeaterDto> heaters) {
        this.heaters = heaters;
    }
    public Set<HeaterDto> getHeaters() {
        return heaters;
    }


    public void setWindows(Set<WindowDto> windows) {
        this.windows = windows;
    }
    public Set<WindowDto> getWindows() {
        return windows;
    }


    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
    public Long getBuildingId() {
        return buildingId;
    }


    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public String getBuildingName() {
        return buildingName;
    }


}
