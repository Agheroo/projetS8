package org.univamu.polytech.backend.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Player {
    
    @Id
    private String id;

    private String name;

    private Float avgScore;

    @OneToMany(mappedBy = "player")
    @JsonBackReference
    private List<GridPlayer> gridPlayers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Float avgScore) {
        this.avgScore = avgScore;
    }

    public List<GridPlayer> getGridPlayers() {
        return gridPlayers;
    }

    public void setGridPlayers(List<GridPlayer> gridPlayers) {
        this.gridPlayers = gridPlayers;
    }
}
