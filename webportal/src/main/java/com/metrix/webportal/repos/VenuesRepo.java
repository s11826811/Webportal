package com.metrix.webportal.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrix.webportal.models.Venues;

public interface VenuesRepo extends JpaRepository<Venues,Integer>/*1. extends a JPA class that provide CRUD function on Venues object*/{
    
}
