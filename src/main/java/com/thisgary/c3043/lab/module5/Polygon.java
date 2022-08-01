package com.thisgary.c3043.lab.module5;

/*
Activity 1
----------
The class Polygon provides a generic operation to calculate the length for width, height and area for Square
and Rectangle, and display purposes of each of the coordinate (x, y) respectively. Class Square and
Rectangle contain only the specific method to display the area for the class.

Write a program to demonstrate the implementation of the above class. To test the class, create a main
class known as ShapeTest. Instantiate the object for mySquare and myRectangle by passing the parameters
(0,0, 0,2, 2,2, 2,0) and (0,0, 0,2, 5,2, 5,0) respectively.

Editor note
-----------
In other news, I want to experiment on the class that can only have one instance.
 */

import java.util.Arrays;

public class Polygon {
    private static Polygon existingInstance;
    private Coordinate[] coordinates;

    public Polygon(Coordinate[] coordinates) {
        if (existingInstance == null) existingInstance = this;
        else throw new IllegalStateException("Already instantiated");
        this.coordinates = coordinates;
    }

    protected static double calculateArea(Coordinate[] coordinates) {
        double area = 0;
        for (int i = 0; i < coordinates.length; i++) {
            int j = i + 1;
            if (j == coordinates.length) j = 0;
            area += coordinates[i].getX() * coordinates[j].getY() - coordinates[i].getY() * coordinates[j].getX();
        }
        return Math.abs(area) / 2;
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getArea() {
        return calculateArea(coordinates);
    }

    public String toString() {
        return "This polygon has an area of " + getArea();
    }

    public void flush() {
        existingInstance = null;
        coordinates = null;
    }

    public static void main(String[] args) {
        Coordinate[] coordinates = {
                new Coordinate(0, 0), new Coordinate(0, 2),
                new Coordinate(5, 2), new Coordinate(5, 0)
        };
        Rectangle myRectangle = new Rectangle(coordinates);
        System.out.println(myRectangle);

        myRectangle.flush();

        coordinates[2].setX(2);
        coordinates[3].setX(2);

        Square mySquare = new Square(coordinates);
        System.out.println(mySquare);
    }
}

class Rectangle extends Polygon {
    public Rectangle(Coordinate[] coordinates) {
        super(coordinates);
        isRectangle(coordinates);
    }

    private static void isRectangle(Coordinate[] coordinates) {
        assert coordinates.length == 4 : "Not a quadrilateral";

        assert (coordinates[0].getY() + coordinates[1].getY() == coordinates[2].getY() - coordinates[3].getY() &&
                coordinates[0].getX() + coordinates[1].getX() == coordinates[2].getX() - coordinates[3].getX())
                : "Not a rectangle";
    }

    protected static double getDistance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
    }

    public String toString() {
        Coordinate[] cs = getCoordinates();
        double a = getDistance(cs[0], cs[1]), b = getDistance(cs[1], cs[2]);
        return "This rectangle has a height of " + Math.max(a, b) +
                ", a width of " + Math.min(a, b) + " and an area of " + getArea();
    }
}

class Square extends Rectangle {
    public Square(Coordinate[] coordinates) {
        super(coordinates);
        isSquare(coordinates);
    }

    protected static void isSquare(Coordinate[] cs) {
        double[] sides = {
                getDistance(cs[0], cs[1]),
                getDistance(cs[1], cs[2]),
                getDistance(cs[2], cs[3]),
                getDistance(cs[3], cs[0])
        };
        assert Arrays.stream(sides).allMatch(side -> side == sides[0]) : "Not a square";
    }

    public String toString() {
        Coordinate[] cs = getCoordinates();
        return "This square has a side of " + getDistance(cs[0], cs[1]) + " and an area of " + getArea();
    }
}
