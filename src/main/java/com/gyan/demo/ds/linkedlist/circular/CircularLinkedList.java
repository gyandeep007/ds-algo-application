package com.gyan.demo.ds.linkedlist.circular;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private Node last;
    private int length=0;

    public CircularLinkedList() {
        last = null;
        length = 0;
    }

    public void insertAtFirst(int key){
       Node node = new Node(key);
        if(isEmpty()){
          last = node;
        }else{
            node.setNext(last.getNext());
        }


        last.setNext(node);
        length++;
    }

    public void insertAtEnd(int key){
        Node node  = new Node(key);
        if(last == null){
            last = node;
            last.setNext(node);
        }else{
            node.setNext(last.getNext());

            last.setNext(node);
            last = node;
        }
      length++;
    }

    public int deleteFromFirst(){
        if(isEmpty())
            throw new NoSuchElementException("list is empty");

        Node temp = last.getNext();
        if(last.getNext() == last){
            last = null;
        }else{
            last.setNext(temp.getNext());
        }
        temp.setNext(null);
        length--;
        return temp.getData();
    }

    public void print(){
        if(isEmpty())
            return;

        Node first = last.getNext();
        while (first != last){
            System.out.print(first.getData()+"-->");
            first = first.getNext();
        }
        System.out.println(first.getData()+"-->null");
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }
}
