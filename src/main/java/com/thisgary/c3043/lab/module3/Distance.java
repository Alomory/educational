package com.thisgary.c3043.lab.module3;

/*
Activity 3
----------
Write a program to convert the distance in miles to kilometer.Your program should accept the input
from the user.Finally,create the main program to display the distance before and after conversion
takes place.Use this qualifier to differentiate the assignment of each of variable.

Note:1mile=1.609344 km
 */

import com.thisgary.library.NumberScanner;

public class Distance {
    private double miles;
    private double km;

    public Distance() {
    }

    public Distance(double miles) {
        this.miles = miles;
        calculateKm();
    }

    private void calculateKm() {
        km = miles * 1.609344;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public double getKm() {
        return km;
    }

    public void overview() {
        System.out.println("The distance in miles is " + miles);
        System.out.println("The distance in kilometers is " + getKm() + "\n");
    }

    public static void main(String[] args) {
        NumberScanner scanner = new NumberScanner();
        double miles = scanner.get("Enter the distance in miles: ").doubleValue();
        Distance distance = new Distance(miles);
        distance.overview();
        miles = scanner.get("Enter the distance in miles: ").doubleValue();
        distance.setMiles(miles);
        distance.overview();
    }
}
