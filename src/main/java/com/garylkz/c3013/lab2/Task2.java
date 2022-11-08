// package com.garylkz.c3013.lab2;

class Node {
	Object element;
	Node next;

	public Node() {
		next = null;
	}

	public Node(Object o) {
		element = o;
		next = null;
	}

	public String toString() {
		return "" + element;
	}
}

class MyLinkedList {
	Node head, tail;

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public void addFirst(Node e) {
		if (head != null && head.next == null) tail = head; // If head is the only node in list
		e.next = head;
		head = e;
	}

	public Node deleteFirst() {
		try {
			return head;
		} finally {
			head = head.next;
			if (head.next == null) tail = null; // If new head is the last node in list
		}
	}

	public void addLast(Node e) {
		tail.next = e;
		tail = e;
	}

	public Node deleteLast() {
		try { 
			return tail;
		} finally {
			Node t = head;
			while (t.next != tail) t = t.next;
			t.next = null;
			tail = t;
		}
	}

	public void add(int index, Node e) {
		if (index < 0) addFirst(e);
		else {
			Node t = head;
			for (int i = 0; i < index; i++) t = t.next;
			e.next = t.next;
			t.next = e;
		}
	}	

	public void printList() {
		System.out.print("List: ");
		Node t = head;
		while (t.next != null) {
			System.out.print(t + ", ");
			t = t.next;
		}
		System.out.println(t);
	}

	public void reverse() {
		Node e = deleteLast(), t = null;
		while (head.next != null) {
			t = e;
			while (t.next != null) t = t.next;
			t.next = deleteLast();
		}
		tail = t.next;
		Node h = head;
		h.next = null;
		addLast(h);
		head = e;
	}
}

public class Task2 {
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.addFirst(new Node("a"));
		l.addFirst(new Node("b"));
		l.addFirst(new Node("c"));
		l.addFirst(new Node("d"));
		l.addFirst(new Node("e"));
		l.printList();

		l.deleteLast();
		l.printList();

		l.add(1, new Node("f"));
		l.printList();

		l.addLast(new Node("g"));
		l.printList();

		l.deleteFirst();
		l.printList();

		l.reverse();
		l.printList();
	}
}
