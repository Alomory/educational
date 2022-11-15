package com.garylkz.c3013.lab2;

class Node1 {
	public int data1;
	public double data2;
	Node1 next;

	public Node1(int d1, double d2) {
		data1 = d1;
		data2 = d2;
		next = null;
	}

	public void printNode() {
		System.out.println("{" + data1 + ", " + data2 + "}");
	}
}

class LinkedList {
	private Node1 first;

	public LinkedList() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void addFirst(int d1, double d2) {
		Node1 node = new Node1(d1, d2);
		node.next = first; // it's a weird way flexing null
		first = node;
	}

	public Node1 deleteFirst() {
		Node1 temp = first;
		first = temp.next;
		return temp;
	}

	public void printList() {
		Node1 t = first;
		System.out.println("List: ");
		while (t != null) {
			t.printNode();
			t = t.next;
		}
		System.out.println("");
	}
}

public class Task1 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for (int i = 1; i <= 5; i++) {
			list.addFirst(i, (double) i);
			list.printList();
		}
		while (!list.isEmpty()) {
			Node1 d = list.deleteFirst();
			System.out.print("Deleted: ");
			d.printNode();
			System.out.println("");
		}
		list.printList();
	}
}
