package com.gyan.demo.ds.tree.rbtree;

import com.gyan.demo.util.ColorUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {
     RedBlackTree tree;


    @Test
    void insert() {

        tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(1);
        tree.insert(20);
        tree.insert(30);
        tree.levelOrderTraversal();
    }
}
