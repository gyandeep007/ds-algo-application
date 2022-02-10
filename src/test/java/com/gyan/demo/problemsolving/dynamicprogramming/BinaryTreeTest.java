package com.gyan.demo.problemsolving.dynamicprogramming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.gyan.demo.problemsolving.dynamicprogramming.BinaryTree.*;

class BinaryTreeTest {

    static Node root;
    @BeforeAll
    public static void createTree(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

       node5.right = node6;
        node6.right = node7;
        node4.left = node8;
        node8.right = node9;
        node9.right = node10;
        root = node1;
    }

    @Test
    void solve() {

        Result result = new Result();
        BinaryTree.solve(root,result);
        System.out.println(result);

    }
}
