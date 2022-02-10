package com.gyan.demo.ds.tree.binarysearchtree;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Stack;

@NoArgsConstructor
@Getter
public class BST {
    private Node root;

    public BST(int key){
        this.root = new Node(key);
    }

    public void insert(int key){
        this.root = insert(root,key);
    }
    // insertion in binary search tree recursive way
    public Node insert(Node root, int key) {
        if(root == null)
            return new Node(key);

        if(key < root.data){
            root.left = insert(root.left,key);
        }
        if(root.data < key){
            root.right = insert(root.right,key);
        }
        return root;
    }

    // insertion in binary search tree iterative way
    public void insertV1(int key){
        if(root == null){
            root = new Node(key);
            return;
        }
        Node current = root;
        while (current != null){
            if(current.data > key){
                if(current.left == null){
                    current.left = new Node(key);
                    return;
                }
                current = current.left;
            }else if(current.data < key){
                if(current.right == null){
                    current.right = new Node(key);
                    return;
                }
                current = current.right;
            }
        }
    }

    // search in binary search tree recursive way
    public boolean search(int key){
        return search(root,key);
    }
    public boolean search(Node root,int key){
        if(root == null)
            return false;

        if(key == root.data)
            return true;
        else if(key < root.data)
            return search(root.left,key);
        else
            return search(root.right,key);
    }

    //search in binary search tree iterative way
    public boolean searchV1(int key){
        return searchV1(root,key);
    }

    public boolean searchV1(Node root,int key){
        if(root == null)
            return false;
        Node current = root;
        while (current != null){
            if(key == current.data)
                return true;
            else if(key < current.data)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    // deletion in binary search tree
    //1. using predecessor
    public void deleteV1(int key){
        root = deleteV1(root,key);
    }
    public Node deleteV1(Node root ,int key){
        if(root == null)
            return null;

        if(key < root.data)
            root.left = deleteV1(root.left,key);
        else if(key > root.data)
            root.right = deleteV1(root.right,key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                root.data = getInorderPredecessor(root.left);
                root.left = deleteV1(root.left,root.data);
            }
        }
            return root;
    }

    private int getInorderPredecessor(Node node) {
        Node current = node;
        while (current.right != null){
            current =current.right;
        }
        return current.data;
    }

    //2. delete using inorder successor
    public void deleteV2(int key){
        root = deleteV2(root,key);
    }

    public Node deleteV2(Node root,int key){
        if(root == null)
            return null;

        if(key < root.data){
            root.left = deleteV2(root.left,key);
        }else if(key > root.data){
            root.right = deleteV2(root.right,key);
        }else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                root.data = getInorderSuccessor(root.right);
                root.right = deleteV2(root.right,root.data);
            }
        }
        return root;
    }

    private int getInorderSuccessor(Node node) {
        Node current = node;
        while (current.left != null){
            current = current.left;
        }
        return current.data;
    }

    public void printBst(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (!stack.isEmpty() || current != null){
            if(current != null) {
                stack.push(current);
                current =current.left;
            }else {
                current = stack.pop();
                System.out.print(current.data+"\t");
                current = current.right;
            }
        }
    }

    public void printBst(){
        printBst(root);
    }
}
