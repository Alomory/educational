package educational.c3013.lab2;

class Node2 {
	String element;
	Node2 next;

	public Node2() {
		next = null;
	}

	public Node2(String s) {
		element = s;
		next = null;
	}

	public String toString() {
		return "" + element;
	}
}

class MyLinkedList {
	Node2 head, tail;

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public void addFirst(Node2 e) {
		if (head != null && head.next == null) tail = head; // If head is the only node in list
		e.next = head;
		head = e;
	}

	public Node2 deleteFirst() {
		try {
			return head;
		} finally {
			head = head.next;
			if (head.next == null) tail = null; // If new head is the last node in list
		}
	}

	public void addLast(Node2 e) {
		tail.next = e;
		tail = e;
	}

	public Node2 deleteLast() {
		try { 
			return tail;
		} finally {
			Node2 t = head;
			while (t.next != tail) t = t.next;
			t.next = null;
			tail = t;
		}
	}

	public void add(int index, Node2 e) {
		if (index < 0) addFirst(e);
		else {
			Node2 t = head;
			for (int i = 0; i < index; i++) t = t.next;
			e.next = t.next;
			t.next = e;
		}
	}	

	public void printList() {
		System.out.print("List: ");
		Node2 t = head;
		while (t.next != null) {
			System.out.print(t + ", ");
			t = t.next;
		}
		System.out.println(t);
	}

	public void reverse() {
		Node2 e = deleteLast(), t = null;
		while (head.next != null) {
			t = e;
			while (t.next != null) t = t.next;
			t.next = deleteLast();
		}
		tail = t.next;
		Node2 h = head;
		h.next = null;
		addLast(h);
		head = e;
	}
}

public class Task2 {
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.addFirst(new Node2("a"));
		l.addFirst(new Node2("b"));
		l.addFirst(new Node2("c"));
		l.addFirst(new Node2("d"));
		l.addFirst(new Node2("e"));
		l.printList();

		l.deleteLast();
		l.printList();

		l.add(1, new Node2("f"));
		l.printList();

		l.addLast(new Node2("g"));
		l.printList();

		l.deleteFirst();
		l.printList();

		l.reverse();
		l.printList();
	}
}
