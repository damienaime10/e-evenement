package com.example.demo.service.impl;

import com.example.demo.DTO.EventDTO;
import com.example.demo.model.Event;
import com.example.demo.model.Publier;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;
    @Override
    public Event createEvent(Event event,EventDTO eventDTO) {
        event.setEventTitle(eventDTO.getEventTitle());
        event.setEventDescription(eventDTO.getEventDescription());
        event.setLocation(eventDTO.getLocation());
        event.setContact(eventDTO.getContact());
        event.setEmail(eventDTO.getEmail());
        event.setLeaderName(eventDTO.getLeaderName());
        event.setPhoto(eventDTO.getPhoto());
        event.setEventDate(eventDTO.getEventDate());

        return this.eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event,EventDTO eventDTO) {

       return this.createEvent(event,eventDTO);
    }

    @Override
    public void deleteEvent(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public Event getEvent(Long id) {
        return this.eventRepository.findById(id).get();
    }

    @Override
    public List<Event> getAllEvent() {
        return this.eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventByPublier(Publier publier) {
        return this.eventRepository.findAllByPublier(publier);
    }
}
