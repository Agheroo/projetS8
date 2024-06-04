package org.univamu.polytech.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.univamu.polytech.backend.entities.GridPlayer;
import org.univamu.polytech.backend.entities.Player;
import org.univamu.polytech.backend.repositories.PlayerRepository;

@RestController
@CrossOrigin("http://frontend:3000")
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("")
    public List<Player> getPlayers(@RequestParam(required = false) String name) {
        return playerRepository.findAll(Example.of(new Player(name)));
    }

    @GetMapping("/best")
    public List<Player> getBestPlayers() {
        return playerRepository.findAll(Sort.by(Direction.DESC, "avgScore"));
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable String id) {
        return playerRepository.findById(id).get();
    }

    @GetMapping("/{id}/gridPlayers")
    public List<GridPlayer> getGridPlayersFromPlayer(@PathVariable String id) {
        return playerRepository.findById(id).get().getGridPlayers();
    }

    @PostMapping("")
    public Player postPlayer(@RequestBody Player player) {
        player.setAvgScore(0f);
        return playerRepository.save(player);
    }

    @PutMapping("/{id}")
    public Player putPlayer(@PathVariable String id, @RequestBody Player player) {
        player.setId(id);
        player.setAvgScore(playerRepository.findById(id).get().getAvgScore());
        return playerRepository.save(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable String id) {
        playerRepository.deleteById(id);
    }
}
