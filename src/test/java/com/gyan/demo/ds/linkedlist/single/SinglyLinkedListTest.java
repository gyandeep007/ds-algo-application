package com.gyan.demo.ds.linkedlist.single;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SinglyLinkedListTest {

    SinglyLinkedList list;
    @BeforeAll
  
    public void beforeAll(){
         list = new SinglyLinkedList();
    }

    @Test
    void createList() {
        Node head = list.createList();
        list.printList();
    }


    void printList(Node head) {
        Node current = head;
        while (current != null){
            System.out.print(current.getData()+"-->");
            current = current.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

    @Test
    void listLength(){
    Node head = list.createList();
    assertEquals(5,length(head));
    }

    int length(Node head){
        if(head == null)
            return 0;
        int count = 0;
        Node current = head;
        while (current != null){
            count++;
            current = current.getNext();
        }
        return count;

    }

    @Test
    void insertAtBegin() {
      Node  head = null;//list.createList();
        System.out.println("before insertion");
        list.printList();
        System.out.println("after insertion");
       head = list.insertAtBegin(11);
         list.printList();

    }

    @Test
    void insertAtEndWithNull() {
        Node  head = null;
        System.out.println("before insertion");
        list.printList();
        System.out.println();
        System.out.println("after insertion");
        head = list.insertAtEnd(11);
        list.printList();

    }
    @Test
    void insertAtEndWithoutNull() {
        Node  head = list.createList();
        System.out.println("before insertion");
        list.printList();
        System.out.println();
        System.out.println("after insertion");
        head = list.insertAtEnd(11);
        list.printList();

    }

    @Test
    void insertAtPos() {
        list.insertAtEnd(10);
        list.insertAtEnd(1);
        list.insertAtEnd(8);
        list.insertAtEnd(11);
        System.out.println("Number of nodes "+list.length());
        System.out.println("before insert");
        list.printList();
        list.insertAtPos(6,55);
        System.out.println("after insert");
        list.printList();
    }

    @Test
    void getElementAtPosition() {
        list.insertAtEnd(10);
        list.insertAtEnd(1);
        list.insertAtEnd(8);
        list.insertAtEnd(11);
        int position =5;
        System.out.println("Element at "+position+" is "+list.getElementAtPosition(position));
    }

    @Test
    void deleteFirst() {
        list.insertAtEnd(10);

        list.printList();
        list.deleteFirst();
        list.printList();
        list.deleteFirst();

    }

    @Test
    void deleteLast() {
        list.insertAtEnd(10);
        list.printList();
        System.out.println(list.deleteLast());
        list.printList();
    }

    @Test
    void deleteAtPosition() {
        list.insertAtEnd(10);
        list.insertAtEnd(1);
        list.insertAtEnd(11);
        list.printList();
        list.deleteAtPosition(3);
        list.printList();

    }

    @Test
    void search() {
        list.insertAtEnd(10);
        list.insertAtEnd(1);
        list.insertAtEnd(11);
        int key =2;
        System.out.println(list.search(key));
    }

    @Test
    void reverseList() {
        list.insertAtEnd(10);
        list.insertAtEnd(1);
       list.insertAtEnd(8);
     Node head =  list.insertAtEnd(11);
      printList(head);
     head = list.reverseListV1(head);
     printList(head);


    }

    @Test
    void middleElement() {
        list.insertAtEnd(10);
        list.insertAtEnd(1);
        list.insertAtEnd(8);
        list.insertAtEnd(12);
        list.insertAtEnd(15);
        list.insertAtEnd(20);
        System.out.println(list.middleElement());
    }

    @Test
    void nThNodeFromLast() {
        list.insertAtEnd(10);
        list.insertAtEnd(1);
        list.insertAtEnd(8);
        list.insertAtEnd(12);
        list.insertAtEnd(15);
        list.insertAtEnd(20);
        System.out.println(list.length());
        int n = 6;
        System.out.println(n+"th node from last "+list.nThNodeFromLastV1(n));
    }

    @Test
    void removeDuplicate() {
        list.insertAtEnd(1);
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(3);
        list.insertAtEnd(3);
        list.printList();
        list.removeDuplicate();
        System.out.println("after removing duplicate");
        list.printList();
    }

    @Test
    void removeLoop() {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(third);

        System.out.println(list.loopExist(head));
        System.out.println(list.startingPointOfLoop(head).getData());
        list.removeLoop(head);
        System.out.println(list.loopExist(head));

    }

    @Test
    public void mergeList(){
        Node head1 = new Node(1);
        Node second = new Node(4);
        Node third = new Node(8);
        Node fourth = new Node(9);
        head1.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        Node head2 = new Node(3);
        Node fifth = new Node(6);
        Node sixth = new Node(7);
        head2.setNext(fifth);
        fifth.setNext(sixth);

        System.out.println("first list");
        printList(head1);
        System.out.println("second list");
        printList(head2);

        Node head = ProgrammingProblem.mergeSortedList(head1,head2);
        System.out.println("merged list");
        printList(head);

    }


    @Test
    public void addList(){
        Node head1 = new Node(3);
        Node second = new Node(4);
        Node third = new Node(3);
        head1.setNext(second);
        second.setNext(third);

        Node head2 = new Node(2);
        Node fifth = new Node(6);
        Node sixth = new Node(4);
        head2.setNext(fifth);
        fifth.setNext(sixth);

        System.out.println("Num1 ");
        printList(head1);
        System.out.println("Num2 ");
        printList(head2);

        Node head = ProgrammingProblem.addList(head1,head2);
        System.out.println("add list");
        printList(head);

    }
}
