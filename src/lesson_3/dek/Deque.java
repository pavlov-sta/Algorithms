package lesson_3.dek;

import lesson_2.ICollection;

public interface Deque<E> extends ICollection {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();


}
