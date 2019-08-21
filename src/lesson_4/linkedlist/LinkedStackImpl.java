package lesson_4.linkedlist;

import lesson_3.stack.Stack;

public class LinkedStackImpl<E> implements Stack<E> {

    private LinkedList<E> data;

    public LinkedStackImpl() {
        this.data = new SimpleLinkedList<>();
    }

    @Override
    public void push(E value) {
        data.insertFirst(value);

    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstValue();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
