package org.univamu.polytech.backend.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.univamu.polytech.backend.nodes.Event;

public interface EventRepository extends Neo4jRepository<Event, Long> {
    
}
