package org.univamu.polytech.backend.entities;

import org.univamu.polytech.backend.enums.Difficulty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Grid {

    @Id
    private Integer id;

    private String topic;

    private Difficulty difficulty;

    private Float avgScore;

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
}
