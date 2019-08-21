package lesson_3.stack;

import lesson_2.ICollection;

public interface Stack<E> extends ICollection {

    void push(E value); //добавляем

    E pop(); // извлечение

    E peek(); // читаем


}
