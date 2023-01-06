package com.garylkz.c3013.lab7;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task2 {
    private int[] data;
    private int size;

    public Task2(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Task2 offer(int value) {
        // Check if the array is full
        if (size == data.length) {
            // Double the size of the array if it is full
            data = Arrays.copyOf(data, data.length * 2);
        }

        // Add the element to the end of the array
        data[size] = value;
        size++;

        // Reorder the elements in the array by priority
        reorderUp();

        return this; // laziness
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("The queue is empty");
        }

        // Get the element at the front of the queue
        int value = data[0];

        // Replace the element at the front of the queue with the last element in the
        // array
        data[0] = data[size - 1];
        size--;

        // Reorder the elements in the array by priority
        reorderDown();

        return value;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("The queue is empty");
        }

        return data[0];
    }

    private void reorderUp() {
        // Start at the last element in the array
        int index = size - 1;

        // While the element at the current index has a higher priority than its parent
        while (index > 0 && data[index] < data[(index - 1) / 2]) {
            // Swap the element with its parent
            int temp = data[index];
            data[index] = data[(index - 1) / 2];
            data[(index - 1) / 2] = temp;

            // Move to the parent
            index = (index - 1) / 2;
        }
    }

    private void reorderDown() {
        // Start at the front of the queue
        int index = 0;

        // While the element at the current index has a lower priority than one of its
        // children
        while (index * 2 + 1 < size
                && (data[index] > data[index * 2 + 1] || (index * 2 + 2 < size && data[index] > data[index * 2 + 2]))) {
            // Find the child with the highest priority
            int childIndex = index * 2 + 1;
            if (index * 2 + 2 < size && data[index * 2 + 1] > data[index * 2 + 2]) {
                childIndex = index * 2 + 2;
            }

            // Swap the element with the child
            int temp = data[index];
            data[index] = data[childIndex];
            data[childIndex] = temp;

            // Move to the child
            index = childIndex;
        }
    }

    public boolean contains(int value) {
        return !isEmpty() && IntStream.of(data).anyMatch(x -> x == value);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Task2 q = new Task2(10);
        q.offer(1).offer(3).offer(5).offer(7).offer(9).offer(11).offer(13);
        System.out.println("contains 7: " + q.contains(7));
        System.out.println("peek: " + q.peek());
        System.out.print("queue: ");
        for (int i = 0; i < 7; i++)
            System.out.print(q.poll() + " ");
        System.out.println();
        System.out.println("peek: ");
        q.peek();
    }
}
