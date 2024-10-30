package com.event.EventManagementSystem.repository;

import com.event.EventManagementSystem.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}

