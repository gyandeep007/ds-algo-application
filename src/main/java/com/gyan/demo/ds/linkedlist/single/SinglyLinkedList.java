package com.gyan.demo.ds.linkedlist.single;


public class SinglyLinkedList {
   private Node head;
   private int count=0;

    public SinglyLinkedList() {
        this.head = null;
        this.count = 0;
    }

    public SinglyLinkedList(Node node) {
        this.head = node;
        this.count = 1;
    }

    //Insertion in linked list
    //1. insert at beginning
      public Node insertAtBegin(int key){
        Node newNode = new Node(key);
        newNode.setNext(head);
        head = newNode;
        count++;
        return head;
      }
    //2. insert at the end
    public Node insertAtEnd(int key){
        Node newNode = new Node(key);
        if(head == null) {
            head = newNode;
            count++;
            return head;
        }
        Node current = head;
        while(null != current.getNext()  ){
            current = current.getNext();
        }
       current.setNext(newNode);
        count++;
        return head;
    }
    //3.insert at given position
    public Node insertAtPos(int pos,int key){
       if(!isValidPosition(pos)){
           throw new RuntimeException("invalid position ");
       }
       Node newNode = new Node(key);
       if(pos == 1){
           newNode.setNext(head);
           head = newNode;
           count++;
           return head;
       }

       Node current = head;
       int count =1;
       while(count < pos-1){
           current= current.getNext();
           count++;
       }
       newNode.setNext(current.getNext());
       current.setNext(newNode);
       count++;
       return head;
    }

    //Deletion in Single LinkedList
    //1. delete from first position
    public int deleteFirst(){
        if(head == null){
            throw new RuntimeException("list is empty");
        }

        int temp = head.getData();
        head = head.getNext();
        count--;
        return temp;

    }
    //2. delete last element
    public int deleteLast(){
        if(head == null)
            throw new RuntimeException("list is empty");

        Node current = head;
        Node prev = null;
        while(null != current.getNext()){
            prev = current;
            current = current.getNext();
        }
        if(prev == null){
            head = null;
        }else {
            prev.setNext(null);
        }
        count--;
        return current.getData();
    }
    //3. delete a node from the list at given position
    public  int deleteAtPosition(int position){
        if(position <= 0 || position > count)
            throw new RuntimeException("invalid position");

        if(position == 1){
            int temp = head.getData();
            head = head.getNext();
            count--;
            return temp;
        }
        Node current = head;
        int counter = 1;
        while (counter < position-1){
            current = current.getNext();
            counter++;
        }
        int temp = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        count--;
        return temp;

    }

    // searching an element in the list
    public boolean search(int key){
        if(head == null)
            throw new RuntimeException("list is empty");

        Node current  = head;
        while(null != current && current.getData() != key){
            current = current.getNext();
        }
        return current==null ? false : true;
    }

    public Node reverseList(Node head){
        if(head == null || head.getNext() == null)
            return head;

        Node prev = null;
        Node current = head;
        Node next = head;
        while (null != current){
            next = next.getNext();
            current.setNext(prev);
            prev=current;
            current = next;

        }

        return prev;
    }

    public Node reverseListV1(Node head){
        if(head == null || head.getNext() == null)
            return head;

        Node temp = head;
        Node current = reverseListV1(head.getNext());
        temp.setNext(null);
        Node temp2 = current;
        while (temp2.getNext()!=null){
            temp2 = temp2.getNext();
        }
        temp2.setNext(temp);

        return current;
    }

    public int middleElement(){
        if(head == null || head.getNext() == null){
            return  head.getData();
        }

        Node slow=head,fast=head;
        while(null != fast && null != fast.getNext()){
        slow = slow.getNext();
        fast = fast.getNext().getNext();
        }
        return  slow.getData();
    }

    public int nThNodeFromLast(int n){
        if(n <=0 || n > count){
            throw new RuntimeException("invalid argument");
        }

        int pos = count - n + 1;
        Node current = head;
        int i = 1;
        while (i < pos){
            current = current.getNext();
            i++;
        }
        return current.getData();
    }

    public int nThNodeFromLastV1(int n){
        if(n <=0 || n > count){
            throw new RuntimeException("invalid argument");
        }
        Node prevPtr=head,fwdPtr = head;
        int i=1;
        while (i <= n){
            fwdPtr = fwdPtr.getNext();
            i++;
        }
        while(null != fwdPtr){

            fwdPtr = fwdPtr.getNext();
            prevPtr = prevPtr.getNext();
        }
        return prevPtr.getData();
    }

    public void removeDuplicate(){
        if(head == null || head.getNext() == null){
            return;
        }

        Node current = head;
        while (current != null){
            Node temp = current;
            while (null != temp.getNext() && temp.getNext().getData() == current.getData()){
                temp = temp.getNext();
            }

            if(temp == current){
                current = current.getNext();
            }else{
                current.setNext(temp.getNext());
                current = temp.getNext();
            }
        }

    }

    public void insertionInSortedList(int key){
        Node newNode = new Node(key);
        if(head == null){
            head = newNode;
            count++;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.getData() < newNode.getData()){
            prev = current;
            current = current.getNext();
        }
        newNode.setNext(current);
        prev.setNext(newNode);
        count++;
    }

    public boolean loopExist(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast)
                return true;
        }
        return false;
    }

    public Node getMeetingPoint(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast)
                return slow;
        }
        return null;

    }

    public Node startingPointOfLoop(Node head){
        Node meetingPoint = getMeetingPoint(head);
        Node current = head;
        while (current != meetingPoint){
            current = current.getNext();
            meetingPoint = meetingPoint.getNext();
        }
        return current;
    }

    public void removeLoop(Node head){
        Node startPoint = startingPointOfLoop(head);
        Node current = startPoint.getNext();
        while ( current.getNext() != startPoint){
            current = current.getNext();
        }
        current.setNext(null);
    }

    public Node createList(){
         head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        return head;
    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.print(current.getData()+"-->");
            current = current.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

    public boolean isValidPosition(int pos){
        return pos >0 && pos <= count+1;
    }

    public int length(){
        return count;
    }


    public int getElementAtPosition(int position){
        if(position <= 0 || position > count ){
            throw  new RuntimeException("position is not valid");
        }

        Node current = head;
        int count = 1;
        while (count < position){
            current = current.getNext();
            count++;
        }

        return current.getData();

    }


}
