package org.univamu.polytech.backend.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.univamu.polytech.backend.nodes.Grid;

public interface GridRepository extends Neo4jRepository<Grid, Long> {
    
}
