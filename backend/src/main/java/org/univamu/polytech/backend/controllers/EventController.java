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
import org.univamu.polytech.backend.entities.Event;
import org.univamu.polytech.backend.repositories.EventRepository;
import org.univamu.polytech.backend.repositories.GridPlayerRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GridPlayerRepository gridPlayerRepository;

    @GetMapping("")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @PostMapping("")
    public Event postEvent(@RequestBody Event event) {
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(event.getGridPlayer().getId().getGrid());
        gridPlayerId.setPlayer(event.getGridPlayer().getId().getPlayer());
        event.setGridPlayer(gridPlayerRepository.findById(gridPlayerId).get());
        return eventRepository.save(event);
    }

    @PutMapping("/{id}")
    public Event putEvent(@PathParam("id") Integer id, @RequestBody Event event) {
        event.setId(id);
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(event.getGridPlayer().getId().getGrid());
        gridPlayerId.setPlayer(event.getGridPlayer().getId().getPlayer());
        event.setGridPlayer(gridPlayerRepository.findById(gridPlayerId).get());
        return eventRepository.save(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathParam("id") Integer id) {
        eventRepository.deleteById(id);
    }
}
