package com.example.Kursova.controller;

import com.example.Kursova.model.ApplicationForm;
import com.example.Kursova.service.ApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/forms")
public class ApplicationFormController {

    @Autowired
    private ApplicationFormService service;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("applicationForm", new ApplicationForm());
        return "add-application-form";
    }

    @PostMapping("/new")
    public String addApplicationForm(@ModelAttribute ApplicationForm appForm, Model model) {
        List<ApplicationForm> matchingApplications = service.findAllMatchingApartments(appForm.getDesiredApartment());

        if (!matchingApplications.isEmpty()) {
            model.addAttribute("matchingApplications", matchingApplications);
            model.addAttribute("newApplication", appForm);
            return "select-matching-apartment";
        } else {
            service.addApplication(appForm);
            return "redirect:/forms/no-matches";
        }
    }

    @GetMapping("/no-matches")
    public String showNoMatchesPage() {
        return "no-matches";
    }

    @PostMapping("/select")
    public String selectMatchingApartment(@RequestParam("selectedId") Long selectedId, @ModelAttribute("newApplication") ApplicationForm newApplication, Model model) {
        ApplicationForm selectedApplication = service.getApplicationById(selectedId);
        if (selectedApplication != null && newApplication != null) {
            service.removeApplication(selectedApplication);
            service.removeApplication(newApplication);
            model.addAttribute("message", "Обидві заявки успішно видалені!");
        } else {
            model.addAttribute("message", "Сталася помилка. Заявка не знайдена.");
        }
        return "result";
    }

    @GetMapping
    public String listForms(Model model) {
        List<ApplicationForm> applications = service.getAllApplications();
        model.addAttribute("applications", applications);
        return "form-list";
    }
}