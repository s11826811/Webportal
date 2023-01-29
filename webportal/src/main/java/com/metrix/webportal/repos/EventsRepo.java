package com.metrix.webportal.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrix.webportal.models.Events;

import jakarta.validation.Valid;

public interface EventsRepo extends JpaRepository<Events,Integer>/*1. extends a JPA class that provide CRUD function on Events object*/{

    Optional<Events> findByEvent(@Valid Events newEvent);
    
}
