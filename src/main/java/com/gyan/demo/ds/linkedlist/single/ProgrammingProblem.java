package com.gyan.demo.ds.linkedlist.single;

public class ProgrammingProblem {


    public static Node mergeSortedList(Node head1,Node head2){
        Node head=null,current=null;
        Node ptr1 = head1;
        Node ptr2 = head2;
       while (ptr1 != null && ptr2 != null){
           if(head == null){
                if(ptr1.getData() <= ptr2.getData()){
                    Node newNode = new Node(ptr1.getData());
                    head = current = newNode;
                    ptr1 = ptr1.getNext();
                }else {
                    Node newNode = new Node(ptr2.getData());
                    head = current = newNode;
                    ptr2 = ptr2.getNext();
                }

           }else {
               if(ptr1.getData() <= ptr2.getData()){
                   Node newNode = new Node(ptr1.getData());
                   current.setNext(newNode);
                   ptr1 = ptr1.getNext();
               }else {
                   Node newNode = new Node(ptr2.getData());
                   current.setNext(newNode);
                   ptr2 = ptr2.getNext();
               }
             current = current.getNext();
           }
       }

       while (ptr1 != null){
           Node newNode  = new Node(ptr1.getData());
          current.setNext(newNode);
          current = current.getNext();
          ptr1 = ptr1.getNext();
       }
        while (ptr2 != null){
            Node newNode  = new Node(ptr2.getData());
            current.setNext(newNode);
            current = current.getNext();
            ptr2 = ptr2.getNext();
        }
       return head;
    }


    public static Node addList(Node head1,Node head2){
        Node head = null;
        int quotient = 0;
        while (head1 != null && head2 != null){
            int tempData = head1.getData()+ head2.getData()+quotient;
            quotient = tempData/10;
            int remainder = tempData%10;
            if(head == null)
                head = new Node(remainder);
            else {
                Node newNode = new Node(remainder);
                newNode.setNext(head);
                head = newNode;
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        if(quotient != 0){
            Node node = new Node(quotient);
            node.setNext(head);
            head = node;
        }
       return head;
    }
}
