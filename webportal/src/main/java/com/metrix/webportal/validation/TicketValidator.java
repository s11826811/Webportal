package com.metrix.webportal.validation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.metrix.webportal.domains.SellForm;
import com.metrix.webportal.models.Events;
import com.metrix.webportal.models.Tickets;
import com.metrix.webportal.models.Venues;
import com.metrix.webportal.repos.EventsRepo;

//1. Annotation to indicate this class is a Spring bean
@Configuration
public class TicketValidator implements Validator {

    @Autowired
    private EventsRepo evtRepo;
    private Venues updVenues;

    @Override
    public boolean supports(Class<?> clazz) {
        return SellForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //1. Cast the object
         SellForm ticket = (SellForm) target; 

        Events event = null;
        Optional<Events> oEvent;
        //2. Find the events object from DB by the event id of the SellForm object
     //  List  <Events> oEvents=evtRepo.findAll();
        if(!oEvent.isPresent()/* 3. Check whether the optional event is NOT present */){
           //4. If not, assign an error messasge "Event not found!" to field eventId
            throw new MetrixException(0, "Event not found!", null);
        } else {
            if(oEvent.isPresent()){
            /* 5. Check whether the event is start sell
                  If not, assign an error messasge "Event not start sell yet!" to field eventId
            */
            throw new MetrixException( -1, "Event not start sell yet!", null);
             }
              /* 6. Check whether the Venue of the event is full. checking is
               Number of Seat < (ticket already sold for this event + number of ticket in SellForm object)
               If yes, assign an error messasge String.format("Not enough seat! {%d} seat left!", (numOfSeat - ticketSold)) to field numberOfTicket
            */        
            if(Venues.getNumberOfSeat() > updVenues.getNumberOfSeat() && !Venues.getEvents().isEmpty()){
                throw new MetrixException (0, String.format("Not enough seat! {%d} seat left!"), null  );
            }
        
        }
        }
    
}