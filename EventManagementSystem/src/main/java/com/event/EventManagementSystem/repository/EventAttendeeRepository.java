package com.event.EventManagementSystem.repository;

import org.springframework.data.repository.query.Param;
import com.event.EventManagementSystem.model.EventAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EventAttendeeRepository extends JpaRepository<EventAttendee, EventAttendee.EventAttendeeKey> {
    List<EventAttendee> findByEventId(Long eventId);
    List<EventAttendee> findByAttendeeId(Long attendeeId);
	
    @Modifying
    @Transactional
    @Query("DELETE FROM EventAttendee ea WHERE ea.event.id = :eventId")
    void deleteByEventId(Long eventId);
}


