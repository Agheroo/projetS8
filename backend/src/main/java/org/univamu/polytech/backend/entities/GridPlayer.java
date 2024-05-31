package org.univamu.polytech.backend.entities;

import java.util.Date;
import java.util.List;

import org.univamu.polytech.backend.embeddables.GridPlayerId;
import org.univamu.polytech.backend.enums.AssistMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;

@Entity
public class GridPlayer {
    
    @EmbeddedId
    private GridPlayerId id;

    @MapsId("grid")
    @ManyToOne
    @JsonManagedReference
    private Grid grid;

    @MapsId("player")
    @ManyToOne
    @JsonManagedReference
    private Player player;

    private Date date;

    private AssistMode assistMode;

    private Integer score;

    @OneToMany(mappedBy = "gridPlayer")
    private List<Event> events;

    public GridPlayerId getId() {
        return id;
    }

    public void setId(GridPlayerId id) {
        this.id = id;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AssistMode getAssistMode() {
        return assistMode;
    }

    public void setAssistMode(AssistMode assistMode) {
        this.assistMode = assistMode;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
