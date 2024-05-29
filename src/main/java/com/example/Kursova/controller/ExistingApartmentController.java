package com.example.Kursova.controller;



import com.example.Kursova.model.ExistingApartment;

import com.example.Kursova.service.ExistingApartmentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller

@RequestMapping("/apartments")

public class ExistingApartmentController {

    @Autowired

    private ExistingApartmentService service;



    @GetMapping("/new")

    public String showApartmentForm(Model model) {

        model.addAttribute("existingApartment", new ExistingApartment());

        return "add-existing-apartment";

    }



    @PostMapping("/new")

    public String addApartment(@ModelAttribute ExistingApartment apartment) {

        service.addApartment(apartment);

        return "redirect:/apartments";

    }



    @GetMapping

    public String listApartments(Model model) {

        model.addAttribute("apartments", service.getAllApartments());

        return "apartment-list";

    }

}