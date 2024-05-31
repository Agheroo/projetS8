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
import org.univamu.polytech.backend.embeddables.GridPlayerId;
import org.univamu.polytech.backend.entities.GridPlayer;
import org.univamu.polytech.backend.repositories.GridPlayerRepository;
import org.univamu.polytech.backend.repositories.GridRepository;
import org.univamu.polytech.backend.repositories.PlayerRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/gridPlayers")
public class GridPlayerController {

    @Autowired
    private GridPlayerRepository gridPlayerRepository;

    @Autowired
    private GridRepository gridRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("")
    public List<GridPlayer> getGridPlayers() {
        return gridPlayerRepository.findAll();
    }

    @PostMapping("")
    public GridPlayer postGridPlayer(@RequestBody GridPlayer gridPlayer) {
        gridPlayer.setGrid(gridRepository.findById(gridPlayer.getGrid().getId()).get());
        gridPlayer.setPlayer(playerRepository.findById(gridPlayer.getPlayer().getId()).get());
        return gridPlayerRepository.save(gridPlayer);
    }

    @PutMapping("/{idGrid}/{idPlayer}")
    public GridPlayer putGridPlayer(@PathParam("idGrid") Integer idGrid, @PathParam("idPlayer") String idPlayer,
            @RequestBody GridPlayer gridPlayer) {
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(idGrid);
        gridPlayerId.setPlayer(idPlayer);
        gridPlayer.setId(gridPlayerId);
        gridPlayer.setGrid(gridRepository.findById(gridPlayer.getGrid().getId()).get());
        gridPlayer.setPlayer(playerRepository.findById(gridPlayer.getPlayer().getId()).get());
        return gridPlayerRepository.save(gridPlayer);
    }

    @DeleteMapping("/{idGrid}/{idPlayer}")
    public void deleteGridPlayer(@PathParam("idGrid") Integer idGrid, @PathParam("idPlayer") String idPlayer) {
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(idGrid);
        gridPlayerId.setPlayer(idPlayer);
        gridPlayerRepository.deleteById(gridPlayerId);
    }
}
