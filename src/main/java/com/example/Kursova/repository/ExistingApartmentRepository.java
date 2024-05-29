package com.example.Kursova.repository;



import com.example.Kursova.model.ExistingApartment;

import org.springframework.stereotype.Repository;



import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;



@Repository

public class ExistingApartmentRepository {

    private final List<ExistingApartment> apartments = new ArrayList<>();



    public void addApartment(ExistingApartment apartment) {

        apartments.add(apartment);

    }



    public List<ExistingApartment> getAllApartments() {

        return new ArrayList<>(apartments);

    }



    // Новий метод для видалення квартири

    public void removeApartment(ExistingApartment apartment) {

        Iterator<ExistingApartment> iterator = apartments.iterator();

        while (iterator.hasNext()) {

            ExistingApartment currentApartment = iterator.next();

            if (currentApartment.equals(apartment)) {

                iterator.remove();

                break;

            }

        }

    }

}