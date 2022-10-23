package com.garylkz.c3043.lab.module4;

import java.util.ArrayList;

/*
Activity 5
----------
Create a program to store the two (2) collection of String object using an ArrayList() class. In your main
program, pass two (2) collection of String via constructor. Finally, display each of the collection String by
invoking toString() method.
 */

public class StringCollection {
    private String str1;
    private String str2;
    private ArrayList<String> collection = new ArrayList<String>();

    public StringCollection(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        collection.add(this.str1);
        collection.add(this.str2);
    }

    public ArrayList<String> getCollection() {
        return collection;
    }

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr1(String str1) {
        collection.set(collection.indexOf(this.str1), str1);
        this.str1 = str1;
    }

    public void setStr2(String str2) {
        collection.set(collection.indexOf(this.str2), str2);
        this.str2 = str2;
    }

    public String toString() {
        return collection.toString();
    }
}
