package com.garylkz.c3043.lecture.class6;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, String securityNumber, double weeklySalary) {
        super(name, securityNumber);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Salary: " + weeklySalary + "\n";
    }

    @Override
    public double earnings() {
        return getWeeklySalary();
    }
}
