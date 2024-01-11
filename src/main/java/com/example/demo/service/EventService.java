package com.example.demo.service;

import com.example.demo.DTO.EventDTO;
import com.example.demo.model.Event;
import com.example.demo.model.Publier;

import java.util.List;

public interface EventService {
    Event createEvent(Event event,EventDTO eventDTO);
    Event updateEvent(Event event,EventDTO eventDTO);

    void deleteEvent(Long id);

    Event getEvent(Long id);

    List<Event> getAllEvent();

    List<Event> getAllEventByPublier(Publier publier);

}
