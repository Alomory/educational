package com.thisgary.c3043.lab.module6;

/*
Activity 2
----------
The Java Consultant class has the following requirements:
- Has a number of working days and a salary rate as MYR800.00 per day.
- Has a method to calculate and display salary. The salary is based on number of working days
  x salary rate per day.

Write a program to demonstrate the use of abstract class and method. In addition, show when
the method overloading and overriding take place in your program.
 */

public class JavaConsultant extends Consultant {
    private int workingDays;

    public JavaConsultant(String name, String company, int age, int workingDays) {
        super(name, company, age);
        System.out.println("Java Consultant constructor called.");
        this.workingDays = workingDays;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public double getSalary() {
        return workingDays * 800.0f;
    }

    public String toString() {
        return super.toString() + ", Salary: " + workingDays + " * 800 = " + getSalary() + "\n";
    }

    public static void main(String[] args) {
        JavaConsultant javaConsultant = new JavaConsultant("Ben", "Smith", 69, 420);
        System.out.println(javaConsultant);
    }
}
