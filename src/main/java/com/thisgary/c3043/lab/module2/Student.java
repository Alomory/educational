package com.thisgary.c3043.lab.module2;

/*
Activity 3
----------
The Student() class consists of attribute such as student id, name, and status. The status can be
assigned either active or suspend. Your program must have minimum three (3) constructors, that will behave
differently when the program is executed at runtime. Create the main program and display the student name,
course and his/her status.
 */

public class Student {
    private String studentId;
    private String studentName;
    private String studentStatus;

    public Student() {
        System.out.println("Student Class");
        System.out.println("=============");
    }

    public Student(String studentId) {
        super();
        this.studentId = studentId;
    }

    public Student(String studentId, String studentName) {
        this(studentId);
        this.studentName = studentName;
    }

    public Student(String studentId, String studentName, String studentStatus) {
        this(studentId, studentName);
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public void overview() {
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Student Name: " + this.studentName);
        System.out.println("Student Status: " + this.studentStatus + "\n");
    }

    public static void main(String[] args) {
        Student student = new Student("CSF3043", "Abdul Rahman", "active");
        student.overview();
    }
}
