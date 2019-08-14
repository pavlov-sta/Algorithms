package lesson_2.array;

public interface Array<E> {

    void add(E value);
    default void addAll(E... values){
        for (E value : values) {
            add(value);
        }
    }

    boolean remove(E value);
    boolean remove(int index);

    E get(int index);

    boolean contains(E value);
    int indexOf(E value);

    int size();
    boolean isEmpty();

    void display();

    void sortBubble();
    void sortSelect();
    void sortInsert();


}
