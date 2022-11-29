package com.garylkz.c3013.lab3;

import java.io.IOException;

public class Task1 {
    private static final int defaultSize = 10; 

    int size; 
    private int top; 
    private char[] stack; 

    Task1() { 
        top = -1; 
        size = defaultSize; 
        stack = new char[defaultSize]; 
    } 
    
    Task1(int size) { 
        top = -1; 
        this.size = size; 
        stack = new char[size]; 
    } 

    public void push(char data) { 
        top++; 
        stack[top]=data;  
    } 

    public char pop() {
        char data = stack [top]; 
        top--; 
        return data; 
    } 
    
    boolean isEmpty () { 
        return top == -1; 
    }

    boolean isFull() {
        return top == size - 1;
    }

    int length() {
        return top;
    }

    public static void main(String[] args) throws IOException {
        Task1 s = new Task1(100); 
        char ch; 

        System.out.println("Please enter your name:"); 
        while ((ch = (char) System.in.read()) != '\n') { 
            if (!s.isFull()) s.push(ch); 
        } 

        System.out.println("Your name reverse is:"); 
        while (!s.isEmpty()) { 
            System.out.print(s.pop()); 
        } 

        System.out.println();
    }
}
