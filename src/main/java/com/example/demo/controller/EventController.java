package com.example.demo.controller;

import com.example.demo.DTO.EventDTO;
import com.example.demo.model.Event;
import com.example.demo.model.Publier;
import com.example.demo.service.EventService;
import com.example.demo.service.PublierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    EventService eventService;
    @Autowired
    PublierService publierService;
    @GetMapping("/events")
    public String events(Model model){
        List <Event> events = this.eventService.getAllEvent();
        model.addAttribute("events",events);
        return "index";
    }

    @GetMapping("/my-event/{id}")
    public String my_event(@RequestParam("id") Long id, Model model){
        model.addAttribute("eventDTO",new EventDTO());

        Publier publier = this.publierService.getPublier(id);
        List <Event> my_events = this.eventService.getAllEventByPublier(publier);
        model.addAttribute("events",my_events);
        return "my_event";
    }

    @PostMapping("/event-post")
    public String create_event(@ModelAttribute("eventDTO") EventDTO eventDTO){

        this.eventService.createEvent(new Event(),eventDTO);
        return "redirect:/my_event";
    }

    @PostMapping("/event-post-update/{id}")
    public  String update_event(@RequestParam("id") Long id,@ModelAttribute("eventDTO") EventDTO eventDTO){
        Event event = this.eventService.getEvent(id);
        event = this.eventService.updateEvent(event,eventDTO);
        return "redirect:/my_event";
    }

    @PostMapping("/delete-event/{id}")
    public String delete_event(@RequestParam("id") Long id){
        this.eventService.deleteEvent(id);
        return "redirect:/my_event";
    }
}
