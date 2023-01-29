package com.metrix.webportal.repos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.metrix.webportal.models.Tickets;

public interface TicketsRepo extends JpaRepository<Tickets,Integer>/*1. extends a JPA class that provide CRUD function on Tickets object*/{
    //1. Annotation for abstract function, filter the tickets records in DB against QR Code
    @Query("Select tickets FROM Tickets tickets where  tickets.qrcode= :qrcode and tickets.id=: id")
   
    //2. Abstract function the return a Optional<Tickets> and accept a String parameter "qrcode"
 
    Optional<Tickets> getTicketByQrCode(String qrcode);
    Optional<Tickets> deleteByqrcode(String qrcode);
}

