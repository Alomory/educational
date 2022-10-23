package com.garylkz.c3043.lecture.class6;

public class CommissionEmployee extends Employee {
    protected double commissionRate;
    protected int sales;

    public CommissionEmployee(String name, String securityNumber, double commissionRate, int sales) {
        super(name, securityNumber);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Salary: " + earnings() + "\n";
    }

    @Override
    public double earnings() {
        return commissionRate * sales;
    }
}
