package org.univamu.polytech.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.univamu.polytech.backend.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
