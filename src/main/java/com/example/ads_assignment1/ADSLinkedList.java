package com.example.ads_assignment1;


public class ADSLinkedList<T> implements ADSListADT<T> {

    private Node<T> first;
    private int size;

    public ADSLinkedList() {
        first = null;
        size = 0;
    }

    @Override
    public void add(T elm) {
        if (elm == null) {
            return;
        }
        Node<T> newNode = new Node(elm, null);
        if (size == 0) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(newNode);
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getElm();
    }

    @Override
    public void insert(int index, T elm) {
        if (index < 0) {
            return;
        }
        if (index > size) {
            add(elm);
            return;
        }
        Node<T> newNode = new Node(elm, null);
        if (size == 0) {
            first = newNode;
        } else {
            Node<T> cur = first;
            int i = 0;
            while (i < index - 1) {
                cur = cur.getNext();
                i++;
            }
            newNode.setNext(cur.getNext());
            cur.setNext(newNode);
        }
        size++;

    }

    @Override
    public boolean remove(T elm) {
        if (elm == null || size == 0) {
            return false;
        }

        if (first.getElm().equals(elm)) {
            first = first.getNext();
            size--;
            return true;
        }

        Node<T> cur = first;
        while (cur.getNext() != null && !cur.getNext().getElm().equals(elm)) {
            cur = cur.getNext();
        }

        if (cur.getNext() != null) {
            cur.setNext(cur.getNext().getNext());
            size--;
            return true;
        }

        return false;
    }

    @Override
    public int indexOf(T elm) {
        Node<T> cur = first;
        int index = 0;

        while (cur != null) {
            if (cur.getElm().equals(elm)) {
                return index;
            }
            cur = cur.getNext();
            index++;
        }

        return -1; // Element not found
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T elm) {
        return indexOf(elm) != -1;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            T removedElement = first.getElm();
            first = first.getNext();
            size--;
            return removedElement;
        }

        Node<T> cur = first;
        int i = 0;
        while (i < index - 1) {
            cur = cur.getNext();
            i++;
        }

        T removedElement = cur.getNext().getElm();
        cur.setNext(cur.getNext().getNext());
        size--;
        return removedElement;
    }

    @Override
    public T set(int index, T elm) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> cur = first;
        int i = 0;
        while (i < index) {
            cur = cur.getNext();
            i++;
        }

        T replacedElement = cur.getElm();
        cur.setElm(elm);
        return replacedElement;
    }

}
