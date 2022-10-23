package com.garylkz.c3043.lecture.class4;

public class Person {
    private String name;
    private int gender;
    private int age;

    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = (gender == 'F') ? 1 : (gender == 'M') ? 0 : -1;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return (gender < 0) ? '?' : (gender > 0) ? 'F' : 'M';
    }

    public void setGender(char gender) {
        this.gender = (gender == 'F') ? 1 : (gender == 'M') ? 0 : -1;
    }

    public String toString() {
        return ((gender < 0) ? "It" : (gender > 0) ? "She" : "He")
                + " is " + name + ", " + age + " years old.";
    }
}
