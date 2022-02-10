package com.gyan.demo.ds.tree.splaytree;

public class Node <T extends Comparable<T>>{
    T data;
    Node<T> leftChild;
    Node<T> rightChild;
    Node<T> parent;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
