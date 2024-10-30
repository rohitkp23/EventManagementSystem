package com.event.EventManagementSystem.controller;

import com.event.EventManagementSystem.model.Attendee;
import com.event.EventManagementSystem.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("api/attendees")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendeeController {
    @Autowired
    private AttendeeService attendeeService;

    @PostMapping
    public Attendee addAttendee(@RequestBody Attendee attendee) {
        return attendeeService.addAttendee(attendee);
    }
}
