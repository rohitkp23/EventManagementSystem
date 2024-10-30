package com.event.EventManagementSystem.service;

import com.event.EventManagementSystem.model.Attendee;
import com.event.EventManagementSystem.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    public Attendee addAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }
}

