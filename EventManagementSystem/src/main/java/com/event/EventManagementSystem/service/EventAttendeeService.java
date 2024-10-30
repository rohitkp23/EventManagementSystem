package com.event.EventManagementSystem.service;

import com.event.EventManagementSystem.model.Event;
import com.event.EventManagementSystem.model.EventAttendee;
import com.event.EventManagementSystem.repository.EventAttendeeRepository;
import com.event.EventManagementSystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAttendeeService {
    @Autowired
    private EventAttendeeRepository eventAttendeeRepository;

    public EventAttendee registerAttendee(EventAttendee eventAttendee) {
        return eventAttendeeRepository.save(eventAttendee);
    }
}

