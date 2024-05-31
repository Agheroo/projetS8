package org.univamu.polytech.backend.entities;

import java.util.List;

import org.univamu.polytech.backend.enums.Difficulty;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Grid {

    @Id
    private Integer id;

    private String topic;

    private Difficulty difficulty;

    private Float avgScore;

    @OneToMany(mappedBy = "grid")
    @JsonBackReference
    private List<GridPlayer> gridPlayers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
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
