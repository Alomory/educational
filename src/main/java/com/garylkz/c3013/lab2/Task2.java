package com.garylkz.c3013.lab2;

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
		e.next = head;
		if (head != null && head.next == null) tail = head;
		head = e;
	}

	public Node deleteFirst() {
		try {
			return head;
		} finally {
			head = head.next;
			if (head.next == null) tail = null;
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
			Node e = head;
			while (e.next != tail) e = e.next;
			e.next = null;
			tail = e;
		}
	}

	public void add(int index, Node e) {
		Node t = head;
		for (int i = 0; i < index-1; i++) {
			t = t.next;
		}
		e.next = t.next;
		t.next = e;
	}	


	public void printList() {
		Node e = head;
		System.out.print("List: ");
		while (e.next != null) {
			System.out.print(e + ", ");
			e = e.next;
		}
		System.out.println(e);
	}
	
	public void reverse() {
		Node e = deleteLast();
		Node f = e;
		while (head.next != null) {
			f = e;
			while (f.next != null) f = f.next;
			f.next = deleteLast();
		}
		tail = f.next;
		Node g = head;
		g.next = null;
		head = e;
		addLast(g);
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
