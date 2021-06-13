package com.mthu;

public interface IStack<T> {

    boolean push(T element) throws StackOverflowException;

    T pop() throws StackUnderflowException;

    int count();

    boolean isEmpty();
}
