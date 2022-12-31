package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

/**
 * WindowDto class used to transfer and to receive data in our REST controllers (entry point in our Java webapp).
 * In this class there is a constructor allows to build a WindowDto from Window entity.
 * WindowDto must always have an empty constructor.
 */
public class WindowDto {

    /**
     * A private Long Integer ID for window.
     */
    private Long id;

    /**
     * A private String name for window.
     */
    private String name;

    /**
     * A Window Status( OPEN <-> CLOSED)
     */
    private WindowStatus windowStatus;

    /**
     * A private Long Integer ID for room.
     */
    private Long roomId;

    /**
     * A private String name for room.
     */
    private String roomName;

    /**
     * No-arg WindowDto constructor(Empty constructor).
     */
    public WindowDto() {
    }

    /**
     * Parameterized WindowDto constructor.
     * This constructor allows to build a WindowDto from Window entity.
     */
    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.windowStatus = window.getWindowStatus();
        this.roomId = window.getRoom().getId();
        this.roomName = window.getRoom().getName();
    }


    /**
     *The method takes one parameter ID of Long type which refers to the new ID of the Window.
     * @param id set Window ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This function returns the ID of the Window.
     * @return returns an ID which contains the ID of the Window.
     */
    public Long getId() {
        return id;
    }


    /**
     * The method takes one parameter name of String type which refers to the new name of the Window.
     * @param name set Window name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function returns the name  of the Window.
     * @return returns a name which contains the name of the Window.
     */
    public String getName() {
        return name;
    }


    /**
     * The method is used to set windowStatus(OPEN, CLOSE) of the Window.
     * @param windowStatus set windowStatus(OPEN, CLOSE).
     */
    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    /**
     * This function returns the WindowStatus of the Window.
     * @return returns WindowStatus(OPEN, CLOSE).
     */
    public WindowStatus getWindowStatus() {
        return windowStatus;
    }


    /**
     *The method takes one parameter ID of Long type which refers to the new ID of the Room.
     * @param roomId set room ID.
     */

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * This function returns the ID of the Room.
     * @return returns an roomId which contains the ID of the Room.
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * The method takes one parameter name of String type which refers to the new name of the Room.
     * @param roomName set Room name.
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * This function returns the name of the Room.
     * @return returns a roomName which contains the name of the Room.
     */
    public String getRoomName() {
        return roomName;
    }



}