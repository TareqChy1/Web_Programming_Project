package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.*;

public class HeaterDto {
    private Long id;
    private String name;
    private Long power;
    private HeaterStatus heaterStatus;
    private Long roomId;
    private String roomName;


    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.heaterStatus = heater.getHeaterStatus();
        this.roomId = heater.getRoom().getId();
        this.roomName = heater.getRoom().getName();
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


    public void setPower(Long power) {
        this.power = power;
    }
    public Long getPower() {
        return power;
    }


    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }


    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    public Long getRoomId() {
        return roomId;
    }


    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public String getRoomName() {
        return roomName;
    }



}
