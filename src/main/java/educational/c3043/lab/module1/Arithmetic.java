package educational.c3043.lab.module1;

import java.util.Scanner;

/*
Activity 2
----------
You have been assigned to write a program to perform an arithmetic addition and subtraction for two (2)
integer numbers key-in by the user. The program should only accept the number key-in by the user as a
positive number. Finally, display the result for addition and subtraction. You should write your program
using an object-oriented approach.
*/

public class Arithmetic {
    private final int number1;
    private final int number2;

    public Arithmetic(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1() {
        return (number1);
    }

    public int getNumber2() {
        return (number2);
    }

    public int addition() {
        return (number1 + number2);
    }

    public int subtraction() {
        return (number1 - number2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1;
        int number2;

        System.out.println("Enter first integer  : ");
        number1 = scanner.nextInt();

        System.out.println("Enter second integer : ");
        number2 = scanner.nextInt();

        Arithmetic arithmetic = new Arithmetic(number1, number2);

        System.out.printf("\nAddition is %d\n", arithmetic.addition());
        System.out.printf("Difference is %d\n", arithmetic.subtraction());

        scanner.close();
    }
}
