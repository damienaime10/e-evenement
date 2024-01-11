package com.example.demo.controller;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.model.Publier;
import com.example.demo.service.PublierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin

public class PublierController {

    @Autowired
    PublierService publierService;
    @GetMapping("/register")
    public  String register_page(Model model){
        model.addAttribute("publier",new Publier());
        return "inscription";
    }

    @PostMapping("register-post")
    public  String register_post(@ModelAttribute("publier") Publier publier,
                                 RedirectAttributes redirectAttributes){

        if(!this.publierService.existEmail(publier.getEmail())){
            redirectAttributes.addFlashAttribute("error","cet email existe déjà.");
            return "redirect:/register";
        }

        this.publierService.createPublier(publier);
        return "/login";
    }

    @GetMapping("/login")
    public String login_page(Model model){
        model.addAttribute("loginDTO",new LoginDTO());
        return "connexion";
    }

    @PostMapping("/login-post")
    public String login_post(@ModelAttribute("loginDTO") LoginDTO loginDTO,
                             RedirectAttributes redirectAttributes){
        if(!publierService.existPublier(loginDTO.getEmail(),loginDTO.getPassword())){
            redirectAttributes.addFlashAttribute("error","email ou mot de passe incorrect");
            return "redirect:/connexion";
        }
        return "/index";
    }

}
