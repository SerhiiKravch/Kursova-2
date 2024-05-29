package com.example.Kursova.model;



public class ExistingApartment {

    private int rooms;

    private double area;

    private int floor;

    private String district;



    // Constructors, getters and setters

    public ExistingApartment() {}



    public ExistingApartment(int rooms, double area, int floor, String district) {

        this.rooms = rooms;

        this.area = area;

        this.floor = floor;

        this.district = district;

    }



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