package com.garylkz.c3043.lab.module6;

/*
Activity 1
----------
Shape has the following requirements:
- Name of the shape
- A method to calculate area that returns a default as 0.0f

Rectangle has the following requirements:
- Has width and length
- A method to calculate area of rectangle as width x length

Circle has the following requirements:
- Has a radius
- Has a method to calculate area of circle as 3.14 x radius x radius

At the main program, create the object by passing the following values:
- For circle, define object name as “Circle” and radius = 4
- For rectangle, define object name as “Rectangle”, width = 2 and length = 4.

If the current object is rectangle, update the length = 6.
Finally, display the area of circle and rectangle.
 */

public class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return 0.0;
    }

    public String toString() {
        return String.format("Shape: %s\n", name);
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Lol", 8, 7);
        System.out.println(rectangle);
        Circle circle = new Circle("Lmao", 6);
        System.out.println(circle);
    }
}

class Rectangle extends Shape {
    private double width, length;

    public Rectangle(String name, double width, double length) {
        super(name);
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String toString() {
        return String.format("%sLength: %s\nWidth: %s\nArea: %s\n", super.toString(), length, width, getArea());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.142 * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return String.format("%sRadius: %.2f\nArea: %.2f\n", super.toString(), radius, getArea());
    }
}
