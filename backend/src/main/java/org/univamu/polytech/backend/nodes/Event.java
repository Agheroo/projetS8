package org.univamu.polytech.backend.nodes;

import java.util.Date;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

enum EventType {
    CELL_INPUT,
    CELL_WRONG,
    CELL_CORRECT
}

@Node
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    private EventType type;

    private Integer x;

    private Integer y;

    @Relationship("OCCURRED_ON")
    private Grid grid;

    @Relationship("PRODUCED_BY")
    private Player player;

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
}
