package com.garylkz.c3043.lab.module4;

import com.garylkz.c3043.lab.module3.Date;
import com.garylkz.library.NumberGetter;

import java.util.Scanner;

public class BirthDate {
    private String name;
    private Date birthDate;

    public BirthDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = scanner.nextLine();
        NumberGetter numberScanner = new NumberGetter();
        int birthDay = numberScanner.getInt("Birth day: ");
        int birthMonth = numberScanner.getInt("Birth month: ");
        int birthYear = numberScanner.getInt("Birth year: ");
        this.birthDate = new Date(birthDay, birthMonth, birthYear);
        scanner.close();
    }

    public void overview() {
        System.out.println("Hello " + this.name + ", your birth date is " + this.birthDate);
    }

    public static void main(String[] args) {
        BirthDate user = new BirthDate();
        user.overview();
        System.out.println("");
    }
}
