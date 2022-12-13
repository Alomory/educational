package com.garylkz.c3013.lab6;

public class Task1 {
    public static void main(String[] args) {
        NonGenericClass nonGenericClassInstance = new NonGenericClass("Final", "Exam");
        nonGenericClassInstance.print();
        MyGenericClass<String, Integer> myGenericClassInstance = new MyGenericClass<>("Final Exam", 2048);
        myGenericClassInstance.print();
    }
}

class NonGenericClass {
    String obj1; 
    String obj2; 
    
    NonGenericClass(String obj1, String obj2) {
        this.obj1 = obj1; 
        this.obj2 = obj2;
    }

    public void print() { 
        System.out.println(obj1); 
        System.out.println(obj2); 
    }
}

class MyGenericClass<T, U> {
    T obj1; 
    U obj2; 
    
    MyGenericClass(T obj1, U obj2) {
        this.obj1 = obj1; 
        this.obj2 = obj2;
    }

    public void print() { 
        System.out.println(obj1); 
        System.out.println(obj2); 
    }
}
