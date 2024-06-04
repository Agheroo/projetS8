package org.univamu.polytech.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univamu.polytech.backend.embeddables.GridPlayerId;
import org.univamu.polytech.backend.entities.Event;
import org.univamu.polytech.backend.enums.EventType;
import org.univamu.polytech.backend.repositories.EventRepository;
import org.univamu.polytech.backend.repositories.GridPlayerRepository;

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

    @GetMapping("/{id}")
    public void getEvent(@PathVariable Integer id) {
        eventRepository.findById(id);
    }

    @PostMapping("")
    public Event postEvent(@RequestBody Event event) {
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(event.getGridPlayer().getId().getGrid());
        gridPlayerId.setPlayer(event.getGridPlayer().getId().getPlayer());
        event.setGridPlayer(gridPlayerRepository.findById(gridPlayerId).get());

        Event response = eventRepository.save(event);

        Integer score;
        Integer correct = (int) response.getGridPlayer().getEvents().stream()
                .filter(e -> e.getType().equals(EventType.CELL_CORRECT)).count();
        Integer wrong = (int) response.getGridPlayer().getEvents().stream()
                .filter(e -> e.getType().equals(EventType.CELL_WRONG)).count();
        Integer diffCoef = response.getGridPlayer().getGrid().getDifficulty().ordinal() + 1;
        Integer assistModeCoef = response.getGridPlayer().getAssistMode().ordinal() + 1;

        score = assistModeCoef * diffCoef * (correct - wrong);
        response.getGridPlayer().setScore(score);

        return response;
    }

    @PutMapping("/{id}")
    public Event putEvent(@PathVariable Integer id, @RequestBody Event event) {
        event.setId(id);
        GridPlayerId gridPlayerId = new GridPlayerId();
        gridPlayerId.setGrid(event.getGridPlayer().getId().getGrid());
        gridPlayerId.setPlayer(event.getGridPlayer().getId().getPlayer());
        event.setGridPlayer(gridPlayerRepository.findById(gridPlayerId).get());

        Event response = eventRepository.save(event);

        Integer score;
        Integer correct = (int) response.getGridPlayer().getEvents().stream()
                .filter(e -> e.getType().equals(EventType.CELL_CORRECT)).count();
        Integer wrong = (int) response.getGridPlayer().getEvents().stream()
                .filter(e -> e.getType().equals(EventType.CELL_WRONG)).count();
        Integer diffCoef = response.getGridPlayer().getGrid().getDifficulty().ordinal() + 1;
        Integer assistModeCoef = response.getGridPlayer().getAssistMode().ordinal() + 1;

        score = assistModeCoef * diffCoef * (correct - wrong);
        response.getGridPlayer().setScore(score);

        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        eventRepository.deleteById(id);
    }
}
