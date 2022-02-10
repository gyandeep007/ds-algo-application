package com.gyan.demo.algo.tree.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeAlgorithmsTest {

    Node root1,root2;
    @BeforeEach
    public void createTree1(){
        Node<Character> node1 = new Node('A');
        Node<Character> node2 = new Node('B');
        Node<Character> node3 = new Node('C');
        Node<Character> node4 = new Node('D');
        Node<Character> node5 = new Node('E');
        Node<Character> node6 = new Node('F');
        Node<Character> node7 = new Node('G');
        Node<Character> node8 = new Node('H');
        node1.left  = node2;
        node1.right = node3;
        node3.left  = node4;
        node3.right = node5;
        node4.left  = node6;
        node4.right = node8;
        node5.right = node7;
        root1 = node1;


    }
    @BeforeEach
    public void createTree2(){
//                          A
//                       /     \
//                      B        C
//                    /  \     /   \
//                   D    E   F      G
        Node<Character> node1 = new Node('A');
        Node<Character> node2 = new Node('B');
        Node<Character> node3 = new Node('C');
        Node<Character> node4 = new Node('D');
        Node<Character> node5 = new Node('E');
        Node<Character> node6 = new Node('F');
        Node<Character> node7 = new Node('G');
        node1.left  = node2;
        node1.right = node3;
        node2.left  = node4;
        node2.right = node5;
        node3.left  = node6;
        node3.right = node7;
        root2 = node1;


    }

    @Test
    void solve1() {
         BinaryTreeAlgorithms.solve1(root2);
    }

    @Test
    void solve2() {
        BinaryTreeAlgorithms.solve2(root2);
    }

    @Test
    void solve3() {
        BinaryTreeAlgorithms.solve3(root2);
    }

    @Test
    void solve4() {
        System.out.println("preorder using recursive way");
        BinaryTreeAlgorithms.solve4(root2);
        System.out.println();
    }

    @Test
    void solve5() {
        System.out.println("preorder using iterative way");
        BinaryTreeAlgorithms.solve5(root2);
        System.out.println();
    }

    @Test
    void solve6() {
        System.out.println("inorder using recursive way");
        BinaryTreeAlgorithms.solve6(root2);
        System.out.println();
    }

    @Test
    void solve7() {
        System.out.println("inorder using iterative way");
        BinaryTreeAlgorithms.solve7(root2);
        System.out.println();
    }

    @Test
    void solve8() {
        System.out.println("post order using recursive way");
        BinaryTreeAlgorithms.solve8 (root2);
        System.out.println();
    }

    @Test
    void solve9() {
        System.out.println("post order using iterative way using 2 stack");
        BinaryTreeAlgorithms.solve9 (root2);
        System.out.println();
    }

    @Test
    void solve10() {
        System.out.println("post order using iterative way using 1 stack");
        BinaryTreeAlgorithms.solve10 (root2);
        System.out.println();
    }

    @Test
    void testSolve3() {
    }
}
