package org.univamu.polytech.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@RestController
@CrossOrigin("http://frontend:3000")
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

    @GetMapping("/{idGrid}/{idPlayer}")
    public void getGridPlayer(@PathVariable Integer idGrid, @PathVariable String idPlayer) {
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(idGrid);
        gridPlayerId.setPlayer(idPlayer);
        gridPlayerRepository.findById(gridPlayerId);
    }

    @PostMapping("")
    public GridPlayer postGridPlayer(@RequestBody GridPlayer gridPlayer) {
        gridPlayer.setScore(0);
        gridPlayer.setGrid(gridRepository.findById(gridPlayer.getId().getGrid()).get());
        gridPlayer.setPlayer(playerRepository.findById(gridPlayer.getId().getPlayer()).get());

        GridPlayer response = gridPlayerRepository.save(gridPlayer);

        response.getPlayer().setAvgScore((float) gridPlayer.getPlayer().getGridPlayers().stream()
                .mapToInt(gp -> gp.getScore()).average().getAsDouble());
        response.getGrid().setAvgScore((float) gridPlayer.getGrid().getGridPlayers().stream()
                .mapToInt(gp -> gp.getScore()).average().getAsDouble());

        return response;
    }

    @PutMapping("/{idGrid}/{idPlayer}")
    public GridPlayer putGridPlayer(@PathVariable Integer idGrid, @PathVariable String idPlayer,
            @RequestBody GridPlayer gridPlayer) {
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(idGrid);
        gridPlayerId.setPlayer(idPlayer);
        gridPlayer.setId(gridPlayerId);
        gridPlayer.setScore(gridPlayerRepository.findById(gridPlayerId).get().getScore());
        gridPlayer.setGrid(gridRepository.findById(gridPlayer.getId().getGrid()).get());
        gridPlayer.setPlayer(playerRepository.findById(gridPlayer.getId().getPlayer()).get());
        
        GridPlayer response = gridPlayerRepository.save(gridPlayer);

        response.getPlayer().setAvgScore((float) gridPlayer.getPlayer().getGridPlayers().stream()
                .mapToInt(gp -> gp.getScore()).average().getAsDouble());
        response.getGrid().setAvgScore((float) gridPlayer.getGrid().getGridPlayers().stream()
                .mapToInt(gp -> gp.getScore()).average().getAsDouble());

        return response;
    }

    @DeleteMapping("/{idGrid}/{idPlayer}")
    public void deleteGridPlayer(@PathVariable Integer idGrid, @PathVariable String idPlayer) {
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(idGrid);
        gridPlayerId.setPlayer(idPlayer);
        gridPlayerRepository.deleteById(gridPlayerId);
    }
}
