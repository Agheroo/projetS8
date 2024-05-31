package org.univamu.polytech.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.univamu.polytech.backend.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
