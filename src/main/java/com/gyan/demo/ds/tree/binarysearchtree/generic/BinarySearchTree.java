package com.gyan.demo.ds.tree.binarysearchtree.generic;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    Node<T> root;

    @Override
    public void traversal() {
        traversal(root);


    }

    private void traversal(Node<T> root){
        if(root != null){
            traversal(root.leftChild);
            System.out.print(root.data+"\t");
            traversal(root.rightChild);
        }
    }

    @Override
    public void insert(T data) {
      root = insert(root,data);
    }

    private Node<T> insert(Node<T> root,T data){
        if(root == null)
            return new Node<>(data);

        if(data.compareTo(root.data) < 0){
            root.leftChild = insert(root.leftChild,data);
        }else{
            root.rightChild = insert(root.rightChild,data);

        }
        return root;
    }

    @Override
    public void delete(T data) {
        root = delete(root,data);
    }

    private Node<T> delete(Node<T> root,T data){
        if(root == null)
            return null;

        if(data.compareTo(root.data) < 0){
            root.leftChild = delete(root.leftChild,data);
        }else if(data.compareTo(root.data) > 0)
            root.rightChild = delete(root.rightChild,data);
        else{
            if(root.leftChild == null)
                return root.rightChild;
            else if(root.rightChild == null)
                return root.leftChild;
            else {
                root.data = getPredecessor(root.leftChild);
                root.leftChild = delete(root.leftChild,data);
            }
        }
        return root;
    }

    private T getPredecessor(Node<T> leftChild) {
        Node<T> current = leftChild;
        while (current.rightChild != null){
            current = current.rightChild;
        }
        return current.data;
    }

    @Override
    public T getMin() {
        if(root == null)
            return null;
        Node<T> current = root;
        while (current.leftChild != null){
            current =current.leftChild;
        }
        return current.data;
    }

    @Override
    public T getMax() {
        if(root == null)
            return null;
        Node<T> current = root;
        while (current.rightChild != null){
            current = current.rightChild;
        }
        return current.data;
    }

    @Override
    public boolean search(T data) {
         return search(root,data);
    }

    private boolean search(Node<T> root,T data){
        if(root == null)
            return false;

        Node<T> current = root;
        while (current != null){
            if(data.compareTo(current.data) == 0)
                return true;
            else if(data.compareTo(root.data) < 0)
                current =current.leftChild;
            else
                current = current.rightChild;
        }
        return false;
    }
}
