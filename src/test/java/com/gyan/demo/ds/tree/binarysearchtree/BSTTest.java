package com.gyan.demo.ds.tree.binarysearchtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    BST bst,bst1;

    @BeforeEach
    public void createBST(){
        bst = new BST();
        bst1 = new BST();
        bst1.insert(25);
        bst1.insert(15);
        bst1.insert(50);
        bst1.insert(25);
        bst1.insert(10);
        bst1.insert(22);
        bst1.insert(35);
        bst1.insert(70);
        bst1.insert(4);
        bst1.insert(12);
        bst1.insert(18);
        bst1.insert(31);
        bst1.insert(44);
        bst1.insert(66);
        bst1.insert(90);
    }

    @Test
    void insert() {
        bst.insert(5);
        bst.insert(4);
        bst.insert(7);
        bst.insert(2);
        bst.insert(6);

        bst.printBst();


    }

    @Test
    void search() {
        System.out.println(bst1.search(67));
    }

    @Test
    void searchV1() {
        System.out.println(bst1.searchV1(66));
    }

    @Test
    void deleteV1() {
        bst1.printBst();
        System.out.println();
        bst1.deleteV1(50);
        bst1.printBst();
    }

    @Test
    void deleteV2() {
        bst1.printBst();
        System.out.println();
        bst1.deleteV2(15);
        bst1.printBst();
    }
}
