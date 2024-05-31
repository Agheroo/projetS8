package org.univamu.polytech.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.univamu.polytech.backend.embeddables.GridPlayerId;
import org.univamu.polytech.backend.entities.GridPlayer;

public interface GridPlayerRepository extends JpaRepository<GridPlayer, GridPlayerId> {
    
}
