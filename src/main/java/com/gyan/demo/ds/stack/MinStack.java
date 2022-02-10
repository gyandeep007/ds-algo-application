package com.gyan.demo.ds.stack;

public class MinStack<T extends Comparable> {
    Stack<T> stack = new Stack<>();
    Stack<T> minStack = new Stack<>();

    public void push(T data) throws Exception{
        T min = data;
        if(!minStack.isEmpty()){
            if(minStack.peek().compareTo(data) == -1){
                min = minStack.peek();
            }
        }
        minStack.push(min);
        stack.push(data);
    }

    public T pop() throws Exception{
        minStack.pop();
       return stack.pop();
    }

    public T getMinimum() throws Exception {
        return minStack.peek();
    }
}
