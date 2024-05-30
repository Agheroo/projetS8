package org.univamu.polytech.backend.nodes;

import java.util.List;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.univamu.polytech.backend.relationships.GridPlayer;

enum Difficulty {
    EASY, MEDIUM, HARD
}

@Node
public class Grid {

    @Id
    private Long id;

    private String topic;

    private Difficulty difficulty;

    private Float avgPerf;

    @Relationship("PLAYED_BY")
    private List<GridPlayer> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Float getAvgPerf() {
        return avgPerf;
    }

    public void setAvgPerf(Float avgPerf) {
        this.avgPerf = avgPerf;
    }

    public List<GridPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<GridPlayer> players) {
        this.players = players;
    }
}
