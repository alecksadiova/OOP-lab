package com.mycompany.m4a1_adiova;
public class Bus extends Vehicle {

    private int capacity;

    public Bus(String vehicleName, int capacity) {
        super(vehicleName);
        this.capacity = capacity;
    }

    @Override
    public void describeMovement() {
        super.describeMovement();
        System.out.println("Bus capacity: " + capacity + " passengers.");
    }
}
