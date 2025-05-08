package com.example.musica.controller;

import com.example.musica.model.Canzone;
import com.example.musica.repository.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/canzoni")
public class CanzoneController {

    @Autowired
    private CanzoneRepository canzoneRepository;

    @GetMapping
    public String listaCanzoni(Model model) {
        model.addAttribute("canzoni", canzoneRepository.findAll());
        return "lista";
    }

    @GetMapping("/nuova")
    public String nuovaCanzone(Model model) {
        model.addAttribute("canzone", new Canzone());
        return "form";
    }

    @PostMapping
    public String salvaCanzone(@ModelAttribute Canzone canzone) {
        canzoneRepository.save(canzone);
        return "redirect:/canzoni";
    }

    @GetMapping("/modifica/{id}")
    public String modificaCanzone(@PathVariable Long id, Model model) {
        Canzone canzone = canzoneRepository.findById(id).orElseThrow();
        model.addAttribute("canzone", canzone);
        return "form";
    }

    @PostMapping("/aggiorna")
    public String aggiornaCanzone(@ModelAttribute Canzone canzone) {
        canzoneRepository.save(canzone);
        return "redirect:/canzoni";
    }

    @GetMapping("/elimina/{id}")
    public String eliminaCanzone(@PathVariable Long id) {
        canzoneRepository.deleteById(id);
    return "redirect:/canzoni";
    }
}
