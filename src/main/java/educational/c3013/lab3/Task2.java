package educational.c3013.lab3;

import educational.lib.NumberGetter;

public class Task2 {
    private static final int defaultSize = 10; 

    int size; 
    private int top; 
    private int[] stack; 

    Task2() { 
        top = -1; 
        size = defaultSize; 
        stack = new int[defaultSize]; 
    } 
    
    Task2(int size) { 
        top = -1; 
        this.size = size; 
        stack = new int[size]; 
    } 

    public void push(int data) { 
        top++; 
        stack[top]=data;  
    } 

    public int pop() {
        int data = stack[top]; 
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

    public static void main(String[] args) {
        Task2 intStack = new Task2(25);
        int decNumber = 0;
        decNumber = NumberGetter.scanInt("Input a number: ");
        boolean stop = false;
        while (!stop) {
            if (!intStack.isFull()) intStack.push(decNumber % 2);
            decNumber = decNumber / 2;
            if (stop = (decNumber == 0 || decNumber == 1 && !intStack.isFull())) intStack.push(decNumber);
        }
        while(!intStack.isEmpty()) System.out.print(intStack.pop()+" ");
        System.out.println();
    }
}
