package com.gyan.demo.ds.tree.rbtree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    int data;
    Node leftChild;
    Node rightChild;
    NodeColor color;
    Node parent;

    public Node(int data) {
        this.data = data;
        this.color = NodeColor.RED;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
