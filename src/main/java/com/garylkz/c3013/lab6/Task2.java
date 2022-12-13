package com.garylkz.c3013.lab6;

public class Task2 {
    public static void main(String[] args) {
        Node<String> root = new Node<>("root");
        Node<String> node1 = root.addChild(new Node<String>("node 1"));
        Node<String> node11 = node1.addChild(new Node<String>("node 11"));
        Node<String> node111 = node11.addChild(new Node<String>("node 111"));
        Node<String> node112 = node11.addChild(new Node<String>("node 112"));
        Node<String> node12 = node1.addChild(new Node<String>("node 12"));
        Node<String> node2 = root.addChild(new Node<String>("node 2"));
        Node<String> node21 = node2.addChild(new Node<String>("node 21"));
        Node<String> node211 = node2.addChild(new Node<String>("node 22"));
        Node<String> node212 = node2.addChild(new Node<String>("node 23"));
        root.printTree(root, " ");
    }
}


