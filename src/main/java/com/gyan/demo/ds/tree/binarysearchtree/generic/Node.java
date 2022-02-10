package com.gyan.demo.ds.tree.binarysearchtree.generic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    T data;
    Node<T> leftChild,rightChild;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
