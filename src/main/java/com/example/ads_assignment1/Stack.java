package com.example.ads_assignment1;

import java.util.EmptyStackException;

public class Stack<T> {

    private ADSLinkedList<T> list;

    public Stack() {
        list = new ADSLinkedList<>();
    }

    // Push an element onto the stack
    public void push(T element) {
        list.add(element);
    }

    // Pop and return the top element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = list.size() - 1;
        return list.remove(lastIndex);
    }

    // Peek at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return list.size();
    }
}
