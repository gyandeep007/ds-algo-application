package com.gyan.demo.ds.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {


    @Test
    public void testStack() throws Exception{
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(25);
        stack.push(24);
        stack.push(50);
        stack.push(51);
        stack.printStack();
        System.out.println();
        System.out.println("popped element "+stack.pop());
        stack.printStack();
    }

}
