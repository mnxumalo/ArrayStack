package com.mthu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {

    @Test
    void push() throws StackOverflowException, StackUnderflowException {
        IStack<Integer> myStack = new ArrayStack<>();
        myStack.push(1);
        assertEquals(1, myStack.count());
        myStack.pop();
    }

    @Test
    void pop() throws StackOverflowException, StackUnderflowException {
        IStack<Integer> myStack = new ArrayStack<>();
        myStack.push(1);
        Integer element = myStack.pop();
        assertEquals(1 ,element);
    }

    @Test
    void size() throws StackOverflowException {
        IStack<Integer> myStack = new ArrayStack<>();
        myStack.push(12);
        myStack.push(23);
        myStack.push(46);
        assertEquals(3, myStack.count());
    }

    @Test
    void isEmpty() {
        IStack<Integer> myStack = new ArrayStack<>();
        assertTrue(myStack.isEmpty());
    }

    @Test
    void pushandpopTest() throws StackOverflowException, StackUnderflowException {
        IStack<Integer> myStack = new ArrayStack<>();
        myStack.push(34);
        myStack.push(36);
        myStack.push(38);
        assertEquals(38, myStack.pop());
        assertEquals(36, myStack.pop());
        assertEquals(34, myStack.pop());
    }

    @Test
    void overflowTest() {

        Exception exception = assertThrows(StackOverflowException.class, () -> {
            IStack<Integer> myStack = new ArrayStack<>(3);
            myStack.push(34);
            myStack.push(36);
            myStack.push(38);
            myStack.push(40);
        });

        String expectedMessage = "Stack is full";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void underflowTest() {

        Exception exception = assertThrows(StackUnderflowException.class, () -> {
            IStack<Integer> myStack = new ArrayStack<>(2);
            myStack.push(34);
            myStack.pop();
            myStack.pop();
        });

        String expectedMessage = "Stack is empty";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }
}