package educational.c3043.lab.module3;

/*
Activity 2
----------
You need to implement a Rectangle class that has the requirements below:
i. Have a variables width and height. The variables can only be accessed by their member’s class.
Additional variable for area is declared for member and non-member class.
ii. Have an additional private method to calculate the area of the rectangle.
iii. Write a simple class Rectangle.
iv. Write a program to test class Rectangle. Try to use the variable height and width and assign the
value 4 and 2 respectively. In addition using variable area to calculate area in main program.
v. Compile the program Rectangle and main program. Briefly explain your result.
vi. If there is an errors, how to fix it. Why the errors occur during the compilation?
 */

public class Rectangle {
    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

//    java: calculateArea() has private access in com.thisgary.lab.module3.Rectangle
//    private int calculateArea() {
    public int calculateArea() {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 2);
        System.out.printf("The area of rectangle is %d\n\n", rectangle.calculateArea());
    }
}
