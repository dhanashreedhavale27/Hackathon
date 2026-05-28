package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*") // Allows your frontend interface to send data across origins
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // 1. Get all events from the database
    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // 2. Save a new event sent from the frontend organizer form
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }
}