package com.event.EventManagementSystem.service;

import com.event.EventManagementSystem.model.Attendee;
import com.event.EventManagementSystem.model.Event;
import com.event.EventManagementSystem.model.EventAttendee;
import com.event.EventManagementSystem.repository.AttendeeRepository;
import com.event.EventManagementSystem.repository.EventAttendeeRepository;
import com.event.EventManagementSystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private EventAttendeeRepository eventAttendeeRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found for this id :: " + id));

    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found for this id :: " + id));
        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setDate(eventDetails.getDate());
        event.setLocation(eventDetails.getLocation());
        return eventRepository.save(event);
    }

    //public void deleteEvent(Long id) {
    //    Event event = eventRepository.findById(id)
        //        .orElseThrow(() -> new RuntimeException("Event not found for this id :: " + id));
        //eventRepository.delete(event);
   // }

	//public void deleteEvent(Long id) {
    // Delete associated attendees first
    //eventAttendeeRepository.deleteByEventId(id);
	
    // Find and delete the event
    //Event event = eventRepository.findById(id)
            //.orElseThrow(() -> new RuntimeException("Event not found for this id :: " + id));
    //eventRepository.delete(event);
//}

public void deleteEvent(Long id) {
    // Delete associated entries in event_attendee
    eventAttendeeRepository.deleteByEventId(id);

    // Delete the event itself
    Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found for this id :: " + id));
    eventRepository.delete(event);

    // Find attendees who are no longer associated with any events
    List<Attendee> orphanedAttendees = attendeeRepository.findAll().stream()
            .filter(attendee -> eventAttendeeRepository.findByAttendeeId(attendee.getId()).isEmpty())
            .collect(Collectors.toList());
    
    // Delete orphaned attendees
    attendeeRepository.deleteAll(orphanedAttendees);
}




    public EventAttendee registerAttendeeToEvent(Long eventId, Long attendeeId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found for this id :: " + eventId));
        Attendee attendee = attendeeRepository.findById(attendeeId)
                .orElseThrow(() -> new RuntimeException("Attendee not found for this id :: " + attendeeId));

        EventAttendee eventAttendee = new EventAttendee();
        EventAttendee.EventAttendeeKey key = new EventAttendee.EventAttendeeKey();
        key.setEventId(eventId);
        key.setAttendeeId(attendeeId);
        eventAttendee.setId(key);
        eventAttendee.setEvent(event);
        eventAttendee.setAttendee(attendee);

        return eventAttendeeRepository.save(eventAttendee);
    }

    public List<Attendee> getAttendeesByEventId(Long eventId) {
        List<EventAttendee> eventAttendees = eventAttendeeRepository.findByEventId(eventId);
        List<Long> attendeeIds = eventAttendees.stream()
                .map(eventAttendee -> eventAttendee.getAttendee().getId())
                .collect(Collectors.toList());

        return attendeeRepository.findAllById(attendeeIds);
    }


}

