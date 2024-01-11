package com.example.demo.repository;

import com.example.demo.DTO.EventDTO;
import com.example.demo.model.Event;
import com.example.demo.model.Publier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository <Event,Long> {

    List<Event> findAllByPublier(Publier publier);
}
