package com.gyan.demo.ds.tree.avl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    int data;
    Node leftNode;
    Node rightNode;
    int height;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                "height=" + height +
                '}';
    }
}
