package org.univamu.polytech.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.univamu.polytech.backend.entities.Grid;

public interface GridRepository extends JpaRepository<Grid, Integer> {

}
