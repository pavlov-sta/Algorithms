package lesson_3.queue;

import lesson_2.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();
}
