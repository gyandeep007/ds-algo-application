package com.gyan.demo.algo.tree.binarytree;

public class Node<T> {
    T data;
    Node<T> left,right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
