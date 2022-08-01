package com.thisgary.c3043.lab.module7;

public class ZeroDivisionException extends ArithmeticException {
    public ZeroDivisionException() {
        super("Division by zero is not allowed. Because I say so.");
    }

    public static void main(String[] args) {
        throw new ZeroDivisionException();
    }
}
