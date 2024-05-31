package org.univamu.polytech.backend.entities;

import java.util.Date;

import org.univamu.polytech.backend.embeddables.GridPlayerId;
import org.univamu.polytech.backend.enums.AssistMode;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class GridPlayer {
    
    @EmbeddedId
    private GridPlayerId id;

    @MapsId("grid")
    @ManyToOne
    private Grid grid;

    @MapsId("player")
    @ManyToOne
    private Player player;

    private Date date;

    private AssistMode assistMode;

    private Integer score;

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
}
