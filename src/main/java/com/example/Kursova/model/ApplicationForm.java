package com.example.Kursova.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;

@Entity
public class ApplicationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;
    private String initials;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rooms", column = @Column(name = "desired_rooms")),
            @AttributeOverride(name = "area", column = @Column(name = "desired_area")),
            @AttributeOverride(name = "floor", column = @Column(name = "desired_floor")),
            @AttributeOverride(name = "district", column = @Column(name = "desired_district"))
    })
    private Apartment desiredApartment = new Apartment();  // Ініціалізація

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rooms", column = @Column(name = "available_rooms")),
            @AttributeOverride(name = "area", column = @Column(name = "available_area")),
            @AttributeOverride(name = "floor", column = @Column(name = "available_floor")),
            @AttributeOverride(name = "district", column = @Column(name = "available_district"))
    })
    private Apartment availableApartment = new Apartment();  // Ініціалізація

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Apartment getDesiredApartment() {
        return desiredApartment;
    }

    public void setDesiredApartment(Apartment desiredApartment) {
        this.desiredApartment = desiredApartment;
    }

    public Apartment getAvailableApartment() {
        return availableApartment;
    }

    public void setAvailableApartment(Apartment availableApartment) {
        this.availableApartment = availableApartment;
    }
}