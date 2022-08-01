package com.thisgary.c3043.lab.module2;

/*
Activity 1
----------
Write a program to display the message “Welcome to OOP class, person_name”. The name of person must
be assigned through the constructor. In addition, the program should prompt message “CSF3043 – Object
Oriented Programming”, when you execute the default constructor. Run your program using default
constructor and your pre-defined constructor. Evaluate the output. You should produce the sample
output as below:

CSE3101 - Object Oriented Programming
Welcome to O0P class, Abdul Rahman
 */

public class Welcome {
    private String name;

    public Welcome(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void overview() {
        System.out.println("CSF3043 - Object Oriented Programming");
        System.out.println("Welcome to OOP class, " + this.name + "\n");
    }

    public static void main(String[] args) {
        Welcome welcome = new Welcome("Abdul Rahman");
        welcome.overview();
    }
}
