package com.garylkz.c3013.lab1;

public class Task1 {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(6, 9);
		double area = rectangle.area();
		System.out.println("Width: " + rectangle.getWidth());
		System.out.println("Height: " + rectangle.getHeight());
		System.out.println("Area: " + area);
		System.out.println("perimeter: " + rectangle.perimeter());
	}	
}

class Rectangle {
	private double height, width;
	
	public double area() {
		double a;
		a = height * width;
		return a;
	}

	public double perimeter() {
		return 2 * (height + width);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
}
