package org.univamu.polytech.backend.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.univamu.polytech.backend.relationships.PlayerGrid;

public interface PlayerGridRepository extends Neo4jRepository<PlayerGrid, Long> {

}
