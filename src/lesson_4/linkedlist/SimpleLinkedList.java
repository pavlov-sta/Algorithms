package lesson_4.linkedlist;

import lesson_4.interator.ListIterator;

import java.util.Iterator;


public class SimpleLinkedList<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);
        entry.next = firstElement;
        firstElement = entry;
        size++;
    }

    @Override
    public E getFirstValue() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previous = null;
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = current.next;
        } else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("________");
        Entry<E> current = firstElement;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println("\n");
        System.out.println("________");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return  new MyListIterator<E>(this);
    }

    private static class MyListIterator<E> implements ListIterator<E> {

        private SimpleLinkedList list;

        private MyListIterator(SimpleLinkedList list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

}
