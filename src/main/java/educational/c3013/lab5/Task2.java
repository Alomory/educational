package educational.c3013.lab5;

public class Task2 {
  public static void main(String[] args) {
    Queue q = new Queue();
    q.insert(2);
    q.insert(1);
    q.insert(0);
    q.insert(3);
    q.insert(0);
    System.out.println(q);
    System.out.println("Peek: " + q.peek());
    System.out.println("Remove: " + q.remove());
    System.out.println("Remove: " + q.remove());
  }
}

class Queue {
  Node front, rear;

  public Queue() {
    front = null;
    rear = null;
  }

  private class Node {
    int i;
    Node next;

    Node (int i) {
      this.i = i;
    }

    public String toString() {
      return "i=" + i;
    }
  }

  public void insert(int i) {
    Node n = new Node(i);
    if (isEmpty()) front = n;
    else rear.next = n;
    rear = n;
  }

  public int remove() {
    if (isEmpty()) throw new RuntimeException("Empty Queue");
    int i = front.i;
    if (front.next == null) rear = null;
    front = front.next;
    return i;
  }

  public int peek() {
    if (isEmpty()) throw new RuntimeException("Empty Queue");
    return front.i;
  }

  public boolean isEmpty() {
    return front == null;
  }

  public static String toString(Node n) {
    return (n == null) ? "" : n + " " + toString(n.next);
  }

  public String toString() {
    return toString(front);
  }
}