package com.thisgary.c3043.lab.module2;

/*
Activity 4
----------
Write a program to convert string number into integer, integer number into double. Prompt the user at main
program to enter two (2) numbers that representing string number and integer number. The program should
validate the string input key-in by user is number. If the input is string (a, b, c, etc.), then assigned the input
as “0”. Otherwise, display the error message. Finally, display the out of conversion.
 */

import java.util.Scanner;

public class NumberChecker {
    private String stringNumber;
    private int intNumber;
    
    public NumberChecker(String stringNumber, int intNumber) {
        this.intNumber = intNumber;
        this.stringNumber = stringNumber;
    }
    
    public void overview() {
        int bufferNumber = 0;
        try {
            bufferNumber = Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            bufferNumber = 0;
        }
        if (bufferNumber != intNumber) {
            System.out.println("We are not the same.");
        } else {
            System.out.println("String Number (Integer): " + intNumber);
            System.out.println("Integer Number (Double): " + (double) intNumber);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("String Numebr: ");
        String stringNumber = s.nextLine();
        System.out.println("Integer Number: ");
        int intNumber = s.nextInt();

        NumberChecker nc = new NumberChecker(stringNumber, intNumber);
        nc.overview();
    }
}
