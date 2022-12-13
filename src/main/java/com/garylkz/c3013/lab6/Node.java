package com.garylkz.c3013.lab6;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T data = null;
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<Node<T>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void printTree(Node<T> root, String delString) {
        if (root == null) {
            return;
        }
        System.out.println(delString + root.data);
        for (Node<T> child : root.children) {
            printTree(child, delString + delString);
        }
    }

    public Node<T> findRoot(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.parent == null) {
            return node;
        }
        return findRoot(node.parent);
    }
}