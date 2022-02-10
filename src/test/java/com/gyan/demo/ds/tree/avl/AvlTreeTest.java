package com.gyan.demo.ds.tree.avl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvlTreeTest {

    AvlTree tree;
    @BeforeEach
     public void init(){
         tree = new AvlTree();
     }
    @Test
    void insert() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
//        tree.insert(40);
//        tree.insert(50);
//        tree.insert(15);

        tree.traverse();

    }

    @Test
    void traverse() {
    }

    @Test
    void delete() {
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(14);

        tree.delete(5);
        tree.traverse();

    }
}
