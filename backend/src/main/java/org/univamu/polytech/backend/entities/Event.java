package org.univamu.polytech.backend.entities;

import java.util.Date;

import org.univamu.polytech.backend.enums.EventType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Integer id;

    private Date date;

    private EventType type;

    private Character newCharacter;

    private Integer x;

    private Integer y;

    @ManyToOne
    private GridPlayer gridPlayer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Character getNewCharacter() {
        return newCharacter;
    }

    public void setNewCharacter(Character newCharacter) {
        this.newCharacter = newCharacter;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public GridPlayer getGridPlayer() {
        return gridPlayer;
    }

    public void setGridPlayer(GridPlayer gridPlayer) {
        this.gridPlayer = gridPlayer;
    }
}
