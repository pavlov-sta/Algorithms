package lesson_3.queue;


import lesson_3.queue.Queue;

import java.util.Arrays;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFAULT_REAR = -1;
    private static final int DEFAULT_FRONT = 0;

    protected final E[] data;
    protected int size; // кол-во элементов в очереди

    private int front; // начало очереди
    private int rear; // конец очереди

    public QueueImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
        front = DEFAULT_FRONT;
        rear = DEFAULT_REAR;
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
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (rear == (data.length-1)) {
            rear = DEFAULT_REAR;
        }

        data[++rear] = value;
        size++;
        return true;
    }



    @Override
    public E remove() {
        if (isEmpty())
            return null;

        if (front == data.length) {
            front = DEFAULT_FRONT;
        }

        E value = data[front++];
        size--;
        return value;

    }

    @Override
    public E peek() {
        return isEmpty() ? null : data[front];
    }

    E[] getQueue() {
        return Arrays.copyOf(data, size);
    }


}
