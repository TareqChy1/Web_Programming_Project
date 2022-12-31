package com.emse.spring.faircorp.model;
import javax.persistence.*;


/**
 * This an Entity called Window in package com.emse.spring.faircorp.model (an entity is a class).
 * @Table Table name : RWINDOW.
 * @Entity The entity name. This name is used to refer to the entity in queries.
 */
@Entity
@Table(name = "RWINDOW")
public class Window {

    /**
     * @Id annotation offer the simplest mechanism to define the mapping to the primary key.
     * @GeneratedValue annotation to automatically generate the primary key value.
     * @Column annotation used mainly in the DDL schema metadata generation.
     * Hibernate generate the database schema automatically, it applies the not null constraint to the particular database column
     * A private Long Integer ID for window.
     */

    @Id
    @GeneratedValue
    @Column(nullable=false)
    private Long id;

    /**
     * @Column annotation is used mainly in the DDL schema metadata generation and also used for adding the column size of MySQL column using SpringBoot
     * A private String name for window.
     */
    @Column(nullable=false, length=255)
    private String name;

    /**
     * In Window entity, added a windowStatus field of the enum type WindowStatus and annotate it with
     * @Enumerated(EnumType.STRING) to declare that its value should be converted from what is effectively a String in the database to the WindowStatus type.
     * @Column annotation used mainly in the DDL schema metadata generation.
     * A Window Status( OPEN <-> CLOSED)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private WindowStatus windowStatus;


    /**
     * @ManyToOne unidirectional association: a window is linked to a room and the room does not have the window list
     */
    @ManyToOne(optional = false)
    private Room room;

    /**
     * No-arg Window constructor(Empty constructor).
     */
    public Window() {
    }

    /**
     * Parameterized Window constructor.
     */

    public Window( String name, WindowStatus status, Room room) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
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
        return this.id;
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
     * The method is used to set room object.
     * @param room used to set room object.
     */

    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return returns room object.
     */

    public Room getRoom() {
        return room;
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


}