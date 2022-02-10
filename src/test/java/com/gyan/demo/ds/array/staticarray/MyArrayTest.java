package com.gyan.demo.ds.array.staticarray;

import org.junit.jupiter.api.Test;


class MyArrayTest {

    MyArray bucket = new MyArray(5);
    int[] numbers = {1,2,3,4,5};
    MyArray bucket1 = new MyArray(numbers);



    @Test
    void insertAtFirst() {
   bucket.insertAtFirst(3);
        bucket.insertAtFirst(4);
        bucket.insertAtLast(6);
        bucket.insertAtLast(5);


        bucket.print();
    }

    @Test
    void isFull() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void insertAtLast() {
    }

    @Test
    void insertAtIndex() {
        bucket.insertAtFirst(3);
        bucket.insertAtFirst(4);
        bucket.insertAtLast(6);
        bucket.insertAtLast(5);
        bucket.insertAtIndex(4,10);
        bucket.insertAtLast(5);

        bucket.print();
    }

    @Test
    void isValid() {
    }

    @Test
    void print() {
    }


    @Test
    void deleteAtIndex() {
        bucket1.print();
        System.out.println(bucket1.deleteAtIndex(0));
    }
}
