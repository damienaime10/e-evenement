package com.example.demo.service.impl;

import com.example.demo.model.Publier;
import com.example.demo.repository.PublierRepository;
import com.example.demo.service.PublierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublierServiceImpl implements PublierService {
    @Autowired
    PublierRepository publierRepository;
    @Override
    public Publier createPublier(Publier publier) {
        return this.publierRepository.save(publier);
    }

    @Override
    public Boolean existEmail(String email) {
        Optional <Publier>  existPublier = this.publierRepository.findByEmail(email);
        return existPublier.isPresent();
    }
}
