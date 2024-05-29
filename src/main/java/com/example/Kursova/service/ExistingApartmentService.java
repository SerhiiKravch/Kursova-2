package com.example.Kursova.service;



import com.example.Kursova.model.ExistingApartment;

import com.example.Kursova.repository.ExistingApartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.util.List;



@Service

public class ExistingApartmentService {

    @Autowired

    private ExistingApartmentRepository repository;



    public void addApartment(ExistingApartment apartment) {

        repository.addApartment(apartment);

    }



    public List<ExistingApartment> getAllApartments() {

        return repository.getAllApartments();

    }

}