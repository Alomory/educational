package com.garylkz.c3043.lab.module2;

import java.util.concurrent.ThreadLocalRandom;

// Activity 2
public class Vehicle {
    private String vehicleType;
    private int chassisNo, productionYear;

    public Vehicle() { // Don't ask
        System.out.println("Vehicle Information");
    }

    public Vehicle(String vehicleType, int chassisNo) {
        this.vehicleType = vehicleType;
        this.chassisNo = chassisNo;
    }

    public Vehicle(String vehicleType, int chassisNo, int productionYear) {
        this(vehicleType, chassisNo);
        this.productionYear = productionYear;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getChassisNo() {
        return chassisNo;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setChassisNo(int chassisNo) {
        this.chassisNo = chassisNo;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public void overview() {
        System.out.println("Vehicle Type   : " + this.vehicleType);
        System.out.println("Chassis No     : " + this.chassisNo);
        System.out.println("Production Year: " + this.productionYear + "\n");
    }

    public static void main(String[] args) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        String[] vehicleTypes = {
                "SEDAN", "COUPE", "SPORTS CAR", "STATION WAGON", "HATCHBACK", "CONVERTIBLE", "SUV", "MINIVAN"
        };
        int i = r.nextInt(10);
        Vehicle vehicle = new Vehicle();
        while (i-- > 0) {
            vehicle.setVehicleType(vehicleTypes[r.nextInt(vehicleTypes.length)]);
            vehicle.setChassisNo(r.nextInt(1000000, 9999999));
            vehicle.setProductionYear(r.nextInt(1990, 2019));
            vehicle.overview();
        }
    }
}
