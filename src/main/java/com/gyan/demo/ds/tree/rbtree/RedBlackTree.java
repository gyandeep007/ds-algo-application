package com.gyan.demo.ds.tree.rbtree;

import com.gyan.demo.util.ColorUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class RedBlackTree implements Tree{

    private Node root;

    @Override
    public void insert(int key) {

        Node newNode = new Node(key);
        root = insert(root,newNode);
        fixViolation(newNode);
    }
    private Node insert(Node root,Node newNode){
        if(root == null)
            return newNode;
        if(root.data < newNode.data){
            root.rightChild = insert(root.rightChild,newNode);
            root.rightChild.parent = root;
        }

        if(root.data > newNode.data){
            root.leftChild = insert(root.leftChild,newNode);
            root.leftChild.parent = root;
        }
        return root;
    }

    private void fixViolation(Node node) {
        // create two pointer parent and grandParent
        Node parent = null;
        Node grandParent = null;
        //
        while (node != root && node.color != NodeColor.BLACK && node.parent.color == NodeColor.RED){
            parent = node.parent;
            grandParent = node.parent.parent;
           // create uncle
            if(parent == grandParent.leftChild){
                // uncle will be right child
                Node uncle = grandParent.rightChild;
                // if parent and uncle both have red color then we will do only recoloring
                // no matter inserted node is right or left child
                // grandParent will be RED and parent,uncle will be BLACK
                if(uncle != null && uncle.color == NodeColor.RED){
                    grandParent.color = NodeColor.RED;
                    parent.color = NodeColor.BLACK;
                    uncle.color = NodeColor.BLACK;
                    node = grandParent;
                }else{
                    //uncle is black then we have to check
                    // newly inserted node is left child or right child
                    // if node is right child then make left rotation on parent
                    if(node == parent.rightChild){
                             leftRotation(parent);
                             node = parent;
                             parent = node.parent;
                    }
                        // node is left child
                        rightRotation(grandParent);
                        //swap the color of parent and grandParent
                        NodeColor tempColor = parent.color;
                        parent.color = grandParent.color;
                        grandParent.color = tempColor;
                        // change the node to parent node
                        node = parent;

                }
            }else{
                // uncle will be left child
                Node uncle = grandParent.leftChild;
                if(uncle != null && uncle.color == NodeColor.RED){
                    // uncle is red
                    grandParent.color = NodeColor.RED;
                    parent.color = NodeColor.BLACK;
                    uncle.color = NodeColor.BLACK;
                    node = grandParent;
                }else{
                    // uncle is black
                    if(node == parent.leftChild){
                        rightRotation(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    leftRotation(grandParent);
                    NodeColor tempColor = grandParent.color;
                    grandParent.color = parent.color;
                    parent.color = tempColor;
                    node = parent;
                }
            }

        }
        if(root.color == NodeColor.RED)
            root.color = NodeColor.BLACK;
    }

    public void leftRotation(Node node){
        System.out.println("left rotation on the node "+node);
        Node tempRightChild = node.rightChild;
        node.rightChild = tempRightChild.leftChild;
        if(node.rightChild != null)
            node.rightChild.parent = node;

        tempRightChild.parent = node.parent;
        if(tempRightChild.parent == null)
            root = tempRightChild;
        else if(node == node.parent.leftChild)
            node.parent.leftChild = tempRightChild;
        else
            node.parent.rightChild = tempRightChild;

        tempRightChild.leftChild = node;
        node.parent = tempRightChild;

    }

    private void rightRotation(Node node){
        System.out.println("right rotation on node "+node);

        Node tempLeftNode = node.leftChild;
        node.leftChild = tempLeftNode.rightChild;
        if(node.leftChild != null)
            node.leftChild.parent = node;

        tempLeftNode.parent = node.parent;
        if(tempLeftNode.parent == null)
            root = tempLeftNode;
        else if(node == node.parent.leftChild )
            node.parent.leftChild = tempLeftNode;
        else
            node.parent.rightChild = tempLeftNode;

        tempLeftNode.rightChild = node;
        node.parent = tempLeftNode;

    }



    @Override
    public void traverse() {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
       traverse(root);
    }

    private void traverse(Node root){
        if(root!= null){
            traverse(root.leftChild);
            String color = root.color==NodeColor.BLACK? ColorUtil.ANSI_BLACK:ColorUtil.ANSI_RED;
            System.out.print(color+root.data+"\t"+ColorUtil.ANSI_RESET);
            traverse(root.rightChild);
        }
    }

    public void levelOrderTraversal(){
        if(root == null)
            return;
        Node current = root;
        int space = height(root)+1;
        boolean printSpace = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(current);
        while (true){
            int count = queue.size();
            if(count == 0)
                break;
            printSpace =true;
            while (count > 0){
                current = queue.poll();
                count--;
                if(printSpace){
                    System.out.printf("%"+space+"s","");
                    printSpace = false;
                    space--;
                }
                String color = current.color==NodeColor.BLACK? ColorUtil.ANSI_BLACK:ColorUtil.ANSI_RED;
                System.out.print(color+current.data+"\t"+ColorUtil.ANSI_RESET);

                if(current.leftChild != null)
                    queue.add(current.leftChild);
                if(current.rightChild != null)
                    queue.add(current.rightChild);

            }
            System.out.println();
        }

    }

    public int height(Node root){
        if(root == null)
            return -1;
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));

    }
}
