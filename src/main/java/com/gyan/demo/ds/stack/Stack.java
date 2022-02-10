package com.gyan.demo.ds.stack;

public class Stack<T> {
    private int MAX_SIZE = 40;
    private Element<T> top;
    private int size = 0;

    public Stack() {
        this.top = null;
        this.size = 0;
    }
    //stack operations
    //1. push operation
    public void push(T data) throws StackOverflowException {
        if(isFull()){
            throw new StackOverflowException("stack is full ");
        }

        Element<T> element = new Element<>(data,top);
        top = element;
        size++;
    }

    public T pop() throws StackUnderflowException {
        if(isEmpty())
            throw new StackUnderflowException("stack is empty");

        T data = top.getData();
        top = top.getNext();
        size--;
        return data;

    }

    public T peek() throws StackUnderflowException {
        if(isEmpty())
            throw new StackUnderflowException("stack is empty");

        return top.getData();
    }


    //helper method
    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("null");
        }
        Element<T> current = top;
        while (current != null){
            System.out.print(current.getData()+"-->");
            current = current.getNext();
        }
        System.out.print("null");
    }
}
