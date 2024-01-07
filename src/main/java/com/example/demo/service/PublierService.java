package com.example.demo.service;

import com.example.demo.model.Publier;

public interface PublierService {
    Publier createPublier(Publier publier);
    Boolean existEmail(String email);
}
