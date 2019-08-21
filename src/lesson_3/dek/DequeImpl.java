package lesson_3.dek;

import lesson_3.queue.QueueImpl;

import java.util.Arrays;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (front == 0)
            front = data.length;

        data[--front] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return  null;
        }
        if (rear < 0)
            rear = data.length - 1;

        size--;
        return data[rear--];
    }
}
