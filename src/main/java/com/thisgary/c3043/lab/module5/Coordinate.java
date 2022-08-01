package com.thisgary.c3043.lab.module5;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static Coordinate create(double x, double y) {
        return new Coordinate(x, y);
    }
}
