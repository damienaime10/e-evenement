package com.example.demo.repository;

import com.example.demo.model.Publier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublierRepository extends JpaRepository <Publier,Long> {
    Optional <Publier> findByEmail(String email);
    Optional <Publier> findByEmailAndPassword(String email, String password);
}
