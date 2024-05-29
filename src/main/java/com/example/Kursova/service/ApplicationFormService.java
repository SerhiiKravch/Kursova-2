package com.example.Kursova.service;

import com.example.Kursova.model.Apartment;
import com.example.Kursova.model.ApplicationForm;
import com.example.Kursova.repository.ApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationFormService {

    @Autowired
    private ApplicationFormRepository repository;

    public void addApplication(ApplicationForm applicationForm) {
        repository.save(applicationForm);
    }

    public List<ApplicationForm> getAllApplications() {
        return repository.findAll();
    }

    public List<ApplicationForm> findAllMatchingApartments(Apartment desiredApartment) {
        List<ApplicationForm> applications = repository.findAll();
        return applications.stream().filter(application ->
                matchesCriteria(application.getAvailableApartment(), desiredApartment)
        ).collect(Collectors.toList());
    }

    public void removeApplication(ApplicationForm applicationForm) {
        repository.delete(applicationForm);
    }

    public ApplicationForm getApplicationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    private boolean matchesCriteria(Apartment availableApartment, Apartment desiredApartment) {
        return availableApartment.getRooms() == desiredApartment.getRooms()
                && availableApartment.getFloor() == desiredApartment.getFloor()
                && Math.abs(availableApartment.getArea() - desiredApartment.getArea()) / desiredApartment.getArea() <= 0.1;
    }
}
