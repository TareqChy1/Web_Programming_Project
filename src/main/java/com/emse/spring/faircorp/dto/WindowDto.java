package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

public class WindowDto {
    private Long id;
    private String name;
    private WindowStatus windowStatus;
    private Long roomId;
    private String roomName;


    public WindowDto() {
    }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.windowStatus = window.getWindowStatus();
        this.roomId = window.getRoom().getId();
        this.roomName = window.getRoom().getName();
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

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }
    public WindowStatus getWindowStatus() {
        return windowStatus;
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