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
import org.univamu.polytech.backend.entities.Player;
import org.univamu.polytech.backend.repositories.PlayerRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("")
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("")
    public Player postPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("/{id}")
    public Player putPlayer(@PathParam("id") String id, @RequestBody Player player) {
        player.setId(id);
        return playerRepository.save(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathParam("id") String id) {
        playerRepository.deleteById(id);
    }
}
