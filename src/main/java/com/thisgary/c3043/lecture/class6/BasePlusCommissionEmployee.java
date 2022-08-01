package com.thisgary.c3043.lecture.class6;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    double baseSalary;

    public BasePlusCommissionEmployee(String name, String securityNumber, double commissionRate, int sales, double baseSalary) {
        super(name, securityNumber, commissionRate, sales);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Salary: " + earnings() + "\n";
    }

    @Override
    public double earnings() {
        return commissionRate * sales + getBaseSalary();
    }
}
