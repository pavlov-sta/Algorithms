package lesson_3.dek;

import java.util.Arrays;

public class DequeImpl<E extends Object & Comparable<? super E>> implements Deque<E> {

    private final E[] data;
    private int size; // кол-во элементов в очереди

    public DequeImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
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

    @Override
    public boolean insertLeft(E value) {

        if (isFull()) {
            return false;
        }
        data[size++] = value;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }
        data[(data.length - 1) - size] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        return isEmpty() ? null : data[data.length - size--];
    }

    @Override
    public E removeRight() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    E[] getDeque() {
        return Arrays.copyOf(data, size);
    }
}
