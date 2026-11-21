package com.mycompany.m4a1_adiova;

public class Vehicle {

    private String vehicleName;

    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void describeMovement() {
        System.out.println(vehicleName + " moves around the campus.");
    }
}
