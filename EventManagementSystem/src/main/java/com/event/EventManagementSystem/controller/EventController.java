package com.event.EventManagementSystem.controller;

import com.event.EventManagementSystem.model.Attendee;
import com.event.EventManagementSystem.model.Event;
import com.event.EventManagementSystem.model.EventAttendee;
import com.event.EventManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/{eventId}/attendees")
    public List<Attendee> getAttendeesByEventId(@PathVariable Long eventId) {
        return eventService.getAttendeesByEventId(eventId);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        return eventService.updateEvent(id, eventDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{eventId}/attendees/{attendeeId}")
    public EventAttendee registerAttendeeToEvent(@PathVariable Long eventId, @PathVariable Long attendeeId) {
        return eventService.registerAttendeeToEvent(eventId, attendeeId);
    }
}
