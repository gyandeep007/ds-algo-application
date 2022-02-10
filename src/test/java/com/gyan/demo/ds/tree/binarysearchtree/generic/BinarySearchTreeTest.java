package com.gyan.demo.ds.tree.binarysearchtree.generic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst;
    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }


    @Test
    void insert() {
        bst.insert(25);
        bst.insert(15);
        bst.insert(50);
        bst.insert(10);
        bst.insert(22);
        bst.insert(35);
        bst.insert(70);
        bst.insert(4);
        bst.insert(12);
        bst.insert(18);
        bst.insert(31);
        bst.insert(44);
        bst.insert(66);
        bst.insert(90);
        bst.traversal();
    }

    @Test
    void traversal() {
        bst.traversal();
    }


    @Test
    void getMin() {
        System.out.println(bst.getMin());
    }

    @Test
    void getMax() {
        System.out.println(bst.getMax());
    }

    @Test
    void search() {
        System.out.println(bst.search(35));
    }

    @Test
    void delete() {
        bst.traversal();
        bst.delete(35);
        bst.traversal();

    }
}
