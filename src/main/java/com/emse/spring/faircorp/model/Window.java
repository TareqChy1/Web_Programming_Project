package com.emse.spring.faircorp.model;
import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {

    @Id
    @GeneratedValue
    @Column(nullable=false)
    private Long id;


    @Column(nullable=false, length=255)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private WindowStatus windowStatus;


    @ManyToOne(optional = false)
    private Room room;


    public Window() {
    }

    public Window( String name, WindowStatus status, Room room) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setRoom(Room room) {
        this.room = room;
    }
    public Room getRoom() {
        return room;
    }


    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }
    public WindowStatus getWindowStatus() {
        return windowStatus;
    }


}