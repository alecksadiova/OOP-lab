package com.mycompany.m4a1_adiova;

public class VehicleDemo {

    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle("Campus Vehicle");
        Bus bus1 = new Bus("Campus Bus", 40);

        System.out.println("=== Campus Vehicle Reporter ===");

        System.out.println("\nTest 1:");
        vehicle1.describeMovement();

        System.out.println("\nTest 2:");
        bus1.describeMovement();

        System.out.println("\nExplanation:");
        System.out.println("Bus inherits the accessible methods of Vehicle.");
        System.out.println("Bus overrides describeMovement() to add its capacity.");
    }
}
