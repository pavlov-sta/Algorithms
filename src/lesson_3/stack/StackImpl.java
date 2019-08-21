package lesson_3.stack;

import java.util.Arrays;

public class StackImpl<E> implements Stack<E> {

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
    }

    @Override
    public void push(E value) {
        data[size++] = value;
    }

    @Override
    public E pop() {
        /*E value = data[--size];
        size--;*/
        return data[--size];
    }

    @Override
    public E peek() {

        return data[size - 1];
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
    public boolean isFull() {
        return size == data.length;
    }

    E[] getSatck() {
        return Arrays.copyOf(data, size);
    }

}
