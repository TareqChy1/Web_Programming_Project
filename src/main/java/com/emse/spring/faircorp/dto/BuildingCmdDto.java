package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Building;
import java.util.Set;
import java.util.stream.Collectors;

public class BuildingCmdDto {
    private Long id;
    private String name;
    private Double outsideTemperature;
    private Set<RoomCmdDto> rooms;

    public BuildingCmdDto() {
    }

    public BuildingCmdDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.outsideTemperature = building.getOutsideTemperature();
        if(building.getRooms() != null) {this.rooms = building.getRooms().stream().map(RoomCmdDto::new).collect(Collectors.toSet());}
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


    public void setRooms(Set<RoomCmdDto> rooms) {
        this.rooms = rooms;
    }
    public Set<RoomCmdDto> getRooms() {
        return rooms;
    }

}
