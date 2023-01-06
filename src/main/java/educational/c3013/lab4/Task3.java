package educational.c3013.lab4;

import java.util.Arrays;

public class Task3<E> {
    private int currentSize; // Current Circular Queue Size
    private E[] circularQueueElements;
    private int maxSize; // Circular Queue maximum size
    private int rear;// rear position of Circular queue(new element enqueued at rear).
    private int front; // front position of Circular queue(element will be dequed from front).

    public Task3(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = (E[]) new Object[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    public void enqueue(E item) throws QueueFullException {
        if (isFull())
            throw new QueueFullException("Circular Queue is full. Element cannot be added");
        else {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;
            if (front == -1)
                front = rear;
        }
    }

    public E dequeue() throws QueueEmptyException {
        E deQueuedElement;
        if (isEmpty())
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public String toString() {
        return Arrays.toString(circularQueueElements);
    }

    public static void main(String[] args) {
        Task3<Integer> c = new Task3<>(8);
        c.enqueue(15);
        c.enqueue(16);
        c.enqueue(17);
        c.enqueue(18);
        c.enqueue(19);
        c.enqueue(20);
        c.enqueue(21);
        c.enqueue(22);
        System.out.println(c);
        System.out.println("Dequeue");
        System.out.println(c.dequeue());
        c.enqueue(23);
        System.out.println("Enqueue");
        System.out.println(c);

        Task3<String> d = new Task3<>(8);
        d.enqueue("A");
        d.enqueue("B");
        d.enqueue("C");
        d.enqueue("D");
        d.enqueue("E");
        d.enqueue("F");
        d.enqueue("G");
        d.enqueue("H");
        System.out.println(d);
        System.out.println("Dequeue");
        System.out.println(d.dequeue());
        d.enqueue("I");
        System.out.println("Enqueue");
        System.out.println(d);
    }
}

class QueueFullException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }
}

class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}