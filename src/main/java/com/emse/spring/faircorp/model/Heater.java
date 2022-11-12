package com.emse.spring.faircorp.model;
import javax.persistence.*;


@Entity
@Table(name = "HEATER")
public class Heater {
    @Id
    @GeneratedValue
    @Column(nullable=false)
    private Long id;


    @Column(nullable=false)
    private String name;


    private Long power;


    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private HeaterStatus heaterStatus;


    @ManyToOne(optional = false)
    private Room room;


    public Heater() {
    }

    public Heater(String name, HeaterStatus status, Long power, Room room) {
        this.heaterStatus = status;
        this.name = name;
        this.power = power;
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


    public void setPower(Long power) {
        this.power = power;
    }
    public Long getPower() {
        return power;
    }


    public void setRoom(Room room) {
        this.room = room;
    }
    public Room getRoom() {
        return room;
    }


    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }



}
