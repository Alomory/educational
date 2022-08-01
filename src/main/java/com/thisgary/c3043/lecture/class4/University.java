package com.thisgary.c3043.lecture.class4;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Student> students = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(String name, char gender, int age) {
        students.add(new Student(name, gender, age));
    }

    public void removeStudent(int index) {
        students.remove(index);
    }

    public String toString() {
        String str = name + "\n";
        str += "Students \n";
        for (Student student : students) {
            str += student.toString() + "\n";
        }
        return str;
    }
}
