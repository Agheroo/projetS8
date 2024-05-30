package org.univamu.polytech.backend.nodes;

import java.util.List;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.univamu.polytech.backend.relationships.PlayerGrid;

@Node
public class Player {

    @Id
    private String id;

    private String name;

    private Float avgPerf;

    @Relationship("PLAYED_ON")
    private List<PlayerGrid> grids;

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

    public Float getAvgPerf() {
        return avgPerf;
    }

    public void setAvgPerf(Float avgPerf) {
        this.avgPerf = avgPerf;
    }

    public List<PlayerGrid> getGrids() {
        return grids;
    }

    public void setGrids(List<PlayerGrid> grids) {
        this.grids = grids;
    }
}
