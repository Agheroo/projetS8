package org.univamu.polytech.backend.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.univamu.polytech.backend.relationships.GridPlayer;

public interface GridPlayerRepository extends Neo4jRepository<GridPlayer, Long> {

}
