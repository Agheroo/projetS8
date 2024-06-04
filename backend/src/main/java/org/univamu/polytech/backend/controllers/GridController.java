package org.univamu.polytech.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.univamu.polytech.backend.entities.Grid;
import org.univamu.polytech.backend.entities.GridPlayer;
import org.univamu.polytech.backend.enums.Difficulty;
import org.univamu.polytech.backend.repositories.GridRepository;

@RestController
@RequestMapping("/grids")
public class GridController {

    @Autowired
    private GridRepository gridRepository;

    @GetMapping("")
    public List<Grid> getGrids(@RequestParam(required = false) String topic,
            @RequestParam(required = false) Difficulty difficulty) {
        return gridRepository.findAll(Example.of(new Grid(topic, difficulty)));
    }

    @GetMapping("/{id}")
    public Grid getGrid(@PathVariable Integer id) {
        System.out.println(id);
        return gridRepository.findById(id).get();
    }

    @GetMapping("/{id}/gridPlayers")
    public List<GridPlayer> getGridPlayersFromGrid(@PathVariable Integer id) {
        return gridRepository.findById(id).get().getGridPlayers();
    }

    @PostMapping("")
    public Grid postGrid(@RequestBody Grid grid) {
        grid.setAvgScore(0f);
        return gridRepository.save(grid);
    }

    @PutMapping("/{id}")
    public Grid putGrid(@PathVariable Integer id, @RequestBody Grid grid) {
        grid.setId(id);
        grid.setAvgScore(gridRepository.findById(id).get().getAvgScore());
        return gridRepository.save(grid);
    }

    @DeleteMapping("/{id}")
    public void deleteGrid(@PathVariable Integer id) {
        gridRepository.deleteById(id);
    }
}
