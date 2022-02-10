package com.gyan.demo.ds.linkedlist.doubly;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private  Node head ;
    private  Node tail ;
    private int length = 0;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    public void insertAtBegin(int key){
        Node node  = new Node(key);

        if(head == null){
            tail = node;
        }else{
            head.setPrev(node);
        }

        node.setNext(head);
        head = node;
        length++;
    }

    public void insertAtEnd(int key){
        Node node = new Node(key);

        if(tail == null){
            head = node;
        }else {
            tail.setNext(node);
            node.setPrev(tail);
        }

        tail = node;
        length++;

    }

    public int deleteFromBeginning(){
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }

        if(head == tail){
            tail = null;
        }else{
            head.getNext().setPrev(null);
        }
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        return temp.getData();
    }

    public int deleteFromEnd(){
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        Node temp = tail;

        if(head == tail){
            head =null;
        }else{
            tail.getPrev().setNext(null);
        }
        tail = tail.getPrev();
        temp.setPrev(null);
        length--;
        return temp.getData();

    }


    public boolean isEmpty(){
        return length == 0; //head == null
    }



    public void print(){

        Node current = head;
        while (current!= null){
            System.out.print(current.getData()+"-->");
            current = current.getNext();
        }
        System.out.print("null");
    }
}
