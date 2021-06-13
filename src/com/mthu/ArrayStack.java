package com.mthu;

import java.util.Arrays;

public class ArrayStack<T> implements IStack<T> {
    private static final int CAPACITY = 10;
    private T[] store;
    private int size = 0;
    private int capacity;

    public ArrayStack() {
        this.capacity = CAPACITY;
        this.store = (T[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.store = (T[]) new Object[capacity];
    }

    @Override
    public boolean push(T element) throws StackOverflowException{

        if(isFull()){
            throw new StackOverflowException("Stack is full");
        }

        store[size++] = element;
        return  true;
    }

    @Override
    public T pop() throws StackUnderflowException{
        if(isEmpty()){
            throw new StackUnderflowException("Stack is empty");
        }

        T element = (T) store[--size];

        store[size] = null;

        return element;
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull(){
        return size >= store.length;
    }
}
