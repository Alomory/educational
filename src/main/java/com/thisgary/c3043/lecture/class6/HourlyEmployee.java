package com.thisgary.c3043.lecture.class6;

public class HourlyEmployee extends Employee {
    private double wage;
    private int hours;

    public HourlyEmployee(String name, String securityNumber, double wage, int hours) {
        super(name, securityNumber);
        this.wage = wage;
        this.hours = hours;
    }


    public double getWage() {
        return wage;
    }

    public void setWage(double hourlySalary) {
        this.wage = hourlySalary;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Salary: " + earnings() + "\n";
    }

    @Override
    public double earnings() {
        return getWage() * getHours();
    }
}
