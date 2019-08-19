package lesson_4.linkedlist;

import lesson_2.ICollection;

public interface LinkedList<E> extends /*ICollection,*/ Iterable<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();

    E getFirstValue();

    class Entry<T> {
        public final T value;
        public Entry<T> next;

        public Entry(T value) {
            this.value = value;
        }
    }
}
