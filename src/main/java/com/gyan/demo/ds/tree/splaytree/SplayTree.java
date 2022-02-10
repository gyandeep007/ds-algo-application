package com.gyan.demo.ds.tree.splaytree;

import java.util.concurrent.ConcurrentMap;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;
    int size=0;

    @Override
    public void insert(T data) {
       Node<T> tempNode = this.root;
       Node<T> parentNode = null;

       while (tempNode != null){
           parentNode= tempNode;
           if(data.compareTo(tempNode.data)<0){
               tempNode = tempNode.leftChild;
           }else{
               tempNode = tempNode.rightChild;
           }
       }

       tempNode = new Node<>(data);
       tempNode.parent = parentNode;

       if(parentNode == null)
           this.root = tempNode;
       else if(parentNode.data.compareTo(tempNode.data)<0)
           parentNode.rightChild = tempNode;
       else
           parentNode.leftChild = tempNode;

       splay(tempNode);
       this.size++;

    }

    @Override
    public Node<T> find(T data) {
        Node<T> current = this.root;
        while (current != null){
            if(current.data.compareTo(data)<0){
                current= current.rightChild;
            }else if(current.data.compareTo(data)>0){
                current = current.leftChild;
            }else{
                splay(current);
                return current;
            }
        }
        splay(current);
        return null;
    }

    private void splay(Node<T> current) {
    }

    @Override
    public T getMin() {
        return null;
    }

    @Override
    public T getMax() {
       return getMax(this.root);
    }

    private T getMax(Node<T> node){
        while (node.rightChild != null ){
            node = node.rightChild;
        }
        return node.data;
    }

    @Override
    public void inorderTraversal() {
        inorder(this.root);
    }

    private void inorder(Node<T> node){
        if(node.leftChild != null){
            inorder(node.leftChild);
        }
        System.out.print(node+"\t");
        if(node.rightChild != null){
            inorder(node.rightChild);
        }
    }
}
