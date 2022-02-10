package com.gyan.demo.ds.linkedlist.doubly;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DoublyLinkedListTest {

    DoublyLinkedList list ;

    @BeforeAll
    public void before(){
        list = new DoublyLinkedList();
    }


    @Test
    void insertAtBegin() {

        list.insertAtBegin(3);
        list.insertAtBegin(5);
        list.insertAtBegin(7);
        list.insertAtBegin(19);
       list.print();
    }

    @Test
    void print() {
    }
}
