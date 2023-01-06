package educational.c3013.lab4;

public class Task1 {
    char q[]; 
    int front, rear, size; 
    
    public Task1(int m) {
        size = m; 
        q = new char[size]; 
        front = rear = -1;
    }

    char dequeue() { 
        if (isEmpty()) {
            System.out.println("Queue is empty"); 
            return (char) 250; 
        } else { 
            char x = q[front]; 
            front++; 
            return x;
        } 
    } 

    void enqueue(char n) {
        if (isFull())  System.out.println("Queue is full");
        else {
            if (front == -1) front = rear = 0; 
            else rear++;
            q[rear] = n;
        }
    }
    
    char peek() { 
        return q[front]; 
    } 

    boolean isEmpty() { 
        return (front == -1 || front > rear); 
    }

    boolean isFull() { 
        return (rear == size - 1); 
    } 

    public String toString() {
        String s = ""; 
        for (int i = 0; i < q.length; i++) s += i+1+"="+q[i]+" ";
        return s;
    }

    public static void main(String[] args) {
        // Task1 myQueue = new Task1(10);
        Task1 myQueue = new Task1(11);
        myQueue.enqueue('a'); 
        myQueue.enqueue('b'); 
        myQueue.enqueue('c'); 
        myQueue.enqueue('d'); 
        myQueue.enqueue('e'); 
        myQueue.enqueue('f'); 
        myQueue.enqueue('g'); 
        myQueue.enqueue('h'); 
        myQueue.enqueue('i'); 
        myQueue.enqueue('j'); 
        System.out.println("First element in queue: "+myQueue.peek()); 
        myQueue.enqueue('k'); 
        System.out.println(myQueue);
    }
} 
