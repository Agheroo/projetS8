package org.univamu.polytech.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univamu.polytech.backend.entities.Grid;
import org.univamu.polytech.backend.entities.GridPlayer;
import org.univamu.polytech.backend.repositories.GridRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/grids")
public class GridController {

    @Autowired
    private GridRepository gridRepository;

    @GetMapping("")
    public List<Grid> getGrids() {
        return gridRepository.findAll();
    }

    @GetMapping("/{id}")
    public Grid getGrid(@PathParam("id") Integer id) {
        return gridRepository.findById(id).get();
    }

    @GetMapping("/{id}/gridPlayers")
    public List<GridPlayer> getGridPlayersFromGrid(@PathParam("id") Integer id) {
        return gridRepository.findById(id).get().getGridPlayers();
    }

    @PostMapping("")
    public Grid postGrid(@RequestBody Grid grid) {
        return gridRepository.save(grid);
    }

    @PutMapping("/{id}")
    public Grid putGrid(@PathParam("id") Integer id, @RequestBody Grid grid) {
        grid.setId(id);
        return gridRepository.save(grid);
    }

    @DeleteMapping("/{id}")
    public void deleteGrid(@PathParam("id") Integer id) {
        gridRepository.deleteById(id);
    }
}
