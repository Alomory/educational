package educational.c3013.lab5;

import java.util.Deque;
import java.util.ArrayDeque;

public class Task3 {
  public static void main(String[] args) { 
    Deque<String> deque = new ArrayDeque<String>(); 
    deque.offer("Data"); 
    deque.offer("Structure"); 
    deque.add("&"); 
    deque.offerFirst("Algorithm"); 
    System.out.println("After offerFirst Traversal..."); 
    for (String s : deque) System.out.println(s); 
    deque.pollLast(); 
    System.out.println("After pollLast() Traversal..."); 
    for (String s : deque) System.out.println(s); 
  }
}
