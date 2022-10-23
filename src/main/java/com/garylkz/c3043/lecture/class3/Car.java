package com.garylkz.c3043.lecture.class3;

public class Car {
    String model;
    int year;
    double price = 0;

    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        if (price > 0) this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Model: " + model + ", Year: " + year + ", Price: " + String.format("%.2f", price);
    }

    public static void main(String[] args) {
        Car car1 = new Car("BMW", 2018, 100000);
        System.out.println(car1);
        car1.setPrice(200000);
        System.out.println(car1);
        Car car2 = new Car("Toyota", 2019, 200000);
        System.out.println(car2);
    }
}
