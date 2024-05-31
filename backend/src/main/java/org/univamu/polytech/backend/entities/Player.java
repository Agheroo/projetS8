package org.univamu.polytech.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player {
    
    @Id
    private String id;

    private String name;

    private Float avgScore;

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
}
