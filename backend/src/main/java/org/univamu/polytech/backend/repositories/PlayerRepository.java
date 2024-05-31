package org.univamu.polytech.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.univamu.polytech.backend.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {
    
}
