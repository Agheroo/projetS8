package org.univamu.polytech.backend.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.univamu.polytech.backend.nodes.Player;

public interface PlayerRepository extends Neo4jRepository<Player, String> {
    
}
