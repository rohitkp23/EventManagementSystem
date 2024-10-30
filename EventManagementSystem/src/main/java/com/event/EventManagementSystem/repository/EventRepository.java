package com.event.EventManagementSystem.repository;

import com.event.EventManagementSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

