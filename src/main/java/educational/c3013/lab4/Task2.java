package educational.c3013.lab4;

public class Task2 {
    public static void main(String[] args) {
        Task1 q = new Task1(10);
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        q.enqueue('d');
        q.dequeue();
        q.dequeue();
        q.enqueue('e');
        q.enqueue('f');
        q.enqueue('g');
        q.enqueue('h');
        q.enqueue('i');
        q.enqueue('j');
        q.enqueue('k');
        q.enqueue('l');
    }
}
