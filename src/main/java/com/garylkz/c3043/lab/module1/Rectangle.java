package com.garylkz.c3043.lab.module1;

import com.garylkz.library.NumberScanner;

import java.util.function.Function;

/*
Activity 3
----------
Calculate the perimeter and area of the rectangle given that the length of the rectangle is 4 cm and the
width is 2 cm. Write your solution by initializing the length and width via constructor. Subsequently,
introduce the method for area() and perimeter(). Finally, in the main program, display the value for area
and perimeter for the rectangle. Compile your program and evaluate the output.
 */

public class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return (length);
    }

    public double getWidth() {
        return (width);
    }

    public double area() {
        return (this.getLength() * this.getWidth());
    }

    public double perimeter() {
        return (2 * (this.getLength() + this.getWidth()));
    }

    public static void main(String[] args) {
        Function<Number, Boolean> rules = n -> n.intValue() > 0;
        NumberScanner ns = new NumberScanner("Positive number only", rules);
        double length = ns.get("Enter the length of rectangle: ").doubleValue();
        double width = ns.get("Enter the width of rectangle: ").doubleValue();

        Rectangle rectangle = new Rectangle(length, width);
        System.out.println("Area of the rectangle is " + rectangle.area());
        System.out.println("Perimeter of the rectangle is " + rectangle.perimeter() + "\n");
    }
}
