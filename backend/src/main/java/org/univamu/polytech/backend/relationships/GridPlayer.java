package org.univamu.polytech.backend.relationships;

import java.util.Date;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.univamu.polytech.backend.nodes.Player;

@RelationshipProperties
public class GridPlayer {
    
    @RelationshipId
    @GeneratedValue
    private Long id;

    private Date date;

    private Integer perf;

    @TargetNode
    private Player player;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPerf() {
        return perf;
    }

    public void setPerf(Integer perf) {
        this.perf = perf;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
