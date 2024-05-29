package com.example.Kursova.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Apartment {
    private int rooms;
    private double area;
    private int floor;
    private String district;

    // Getters and Setters
    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}