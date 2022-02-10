package com.gyan.demo.ds.tree.avl;

public class AvlTree implements Tree{

    Node root;

    @Override
    public void insert(int key) {
      //  System.out.println("insert started for node "+key);
        root = insert(root,key);
      //  System.out.println("insert completed for node "+key);
    }

    private Node insert(Node root,int key){
        if(root == null)
            return new Node(key);

        if(key < root.data)
            root.leftNode = insert(root.leftNode,key);
        else
            root.rightNode = insert(root.rightNode,key);

        root.height = 1+ Math.max(height(root.leftNode),height(root.rightNode));
        root = validateInsert(root,key);
      //  System.out.println(root);
        return root;
    }

    private Node validateInsert(Node root,int key) {
      int balanceFactor = getBalanceFactor(root);
      if(balanceFactor > 1){   //left case
          if(root.leftNode.data < key){
              //left-right case
              root.leftNode = leftRotation(root.leftNode);
              root = rightRotation(root);
          }else{
              //left left case
              root = rightRotation(root);
          }
      }
      if(balanceFactor < -1){
          if(root.rightNode.data > key){
              //right-left case
              root.rightNode = rightRotation(root.rightNode);
              root = leftRotation(root);
          }else{
              //right-right case
              root = leftRotation(root);
          }

      }
      return root;
    }

    private Node rightRotation(Node root) {
        System.out.println("Rotating right on node "+root.data);

        Node leftChild = root.leftNode;
        root.leftNode = leftChild.rightNode;
        leftChild.rightNode = root;
        root.height = 1 + Math.max(height(root.leftNode),height(root.rightNode));
        leftChild.height = 1 + Math.max(height(leftChild.leftNode),height(leftChild.rightNode));
        return leftChild;

    }

    private Node leftRotation(Node root) {
        System.out.println("Rotating left on node "+root.data);
        Node rightChild = root.rightNode;
        root.rightNode =  rightChild.leftNode;
        rightChild.leftNode = root;

        root.height = 1 + Math.max(height(root.leftNode),height(root.rightNode));
        rightChild.height = 1 + Math.max(height(rightChild.leftNode),height(rightChild.rightNode));
        return rightChild;
    }

    private int getBalanceFactor(Node node){
        return height(node.leftNode) - height(node.rightNode);
    }

    private int height(Node node){
        if(node == null)
            return -1;

        return node.height;
    }
    @Override
    public void traverse() {

        inorder(this.root);

    }

    private void inorder(Node root){
        if(root != null){
            inorder(root.leftNode);
            System.out.print(root.data+"\t");
            inorder(root.rightNode);
        }
    }

    @Override
    public void delete(int key) {
        root = delete(root,key);
    }

    private Node delete(Node node,int key){
        if(node == null)
            return null;

        if(key  < node.data) {
            node.leftNode = delete(node.leftNode, key);
        }else if (key > node.data) {
            node.rightNode = delete(node.rightNode, key);
        }else {
            if (node.leftNode == null) {
                return node.rightNode;
            }else if (node.rightNode == null) {
                return node.leftNode;
            }else{
                node.data = getInorderPredecessor(node.leftNode);
                node.leftNode = delete(node.leftNode, node.data);

            }

        }
        node.height = 1 + Math.max(height(node.leftNode),height(node.rightNode));
        node = validateDelete(node);
        return node;
    }

    private Node validateDelete(Node node) {
        int balanceFactor = getBalanceFactor(node);
        //left case
        if(balanceFactor > 1){
            if(getBalanceFactor(node.leftNode) < 0){
                //left-right case
                node.leftNode = rightRotation(node.leftNode);
            }
            node = rightRotation(node);
        }
        //right-case
        if(balanceFactor < -1){
            if(getBalanceFactor(node.rightNode) > 0){
                //right-left case
                node.rightNode = rightRotation(node.rightNode);
            }
            node = leftRotation(node);
        }
        return node;
    }

    private int getInorderPredecessor(Node node) {
        Node current = node;
        while (current.rightNode != null){
            current = current.rightNode;
        }
            return current.data;
    }
}
