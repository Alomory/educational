package com.garylkz.c3043.lecture.class6;

public abstract class Employee {
    String name, securityNumber;

    public Employee(String name, String securityNumber) {
        this.name = name;
        this.securityNumber = securityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Security Number: " + securityNumber + "\n";
    }

    public abstract double earnings();
}
