package com.thisgary.c3043.lab.module1;

import java.util.Scanner;

/*
Activity 5
----------
1. Given the UML class diagram below is designed for a simple program that displays the
   Grade book course name as key-in by the user.

          Grade book
  - CourseName      : String
  + getCourseName() : String
  + setCourseName() : void
  + displayMessage()

2. The specifications of the program are given below;
i.   Program will prompt “Please enter the course name”.
ii.  User will key-in the course name and press ENTER button.
iii. The program will display the output at window console as below;
 */
public class GradeBook {
    private String courseName;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return (courseName);
    }

    public void displayMessage() {
        System.out.println("Welcome to the grade book for");
        System.out.println(this.getCourseName() + "!");
    }

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        System.out.print("Please enter the course name: ");
        gradeBook.setCourseName(new Scanner(System.in).nextLine());
        gradeBook.displayMessage();
    }
}
