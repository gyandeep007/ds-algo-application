package com.gyan.demo.ds.queue;

import java.lang.reflect.Array;


public class Queue<T> {
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;
    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;
    private int size;

    public Queue(Class<T> clazz){
        elements = (T[])Array.newInstance(clazz,MAX_SIZE);
    }
    public Queue(int capacity,Class<T> clazz){
        elements = (T[])Array.newInstance(clazz,capacity);
    }

    public void enqueue(T data) throws QueueOverflowException {
        if(isFull())
            throw new QueueOverflowException("queue is full");

        tailIndex = tailIndex + 1 % elements.length;
        elements[tailIndex] = data;

        if(headIndex == SPECIAL_EMPTY_VALUE){
            headIndex = tailIndex;
        }
        size++;

    }

    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw  new QueueUnderflowException("queue is empty");
        }
        T data = elements[headIndex];
        if(headIndex == tailIndex){
            headIndex = SPECIAL_EMPTY_VALUE;
        }else {
            headIndex = (headIndex + 1) % elements.length;
        }
        size--;
        return data;
    }

    public boolean isFull(){
        return (tailIndex + 1) % elements.length == headIndex;
    }

    public boolean isEmpty(){
        return  headIndex == SPECIAL_EMPTY_VALUE;
    }

    public int getSize() {
        return size;
    }
}
