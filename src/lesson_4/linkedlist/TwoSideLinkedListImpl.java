package lesson_4.linkedlist;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedList<E> implements TwoSideLinkedList<E> {

    private Entry<E> lastElement; // ссылка на последний элемент

    @Override
    public void insertLast(E value) {
        Entry<E> entry = new Entry<>(value);

        if (isEmpty()) {  // если список пустой
            firstElement = entry; // наш элемент превый
        } else {
            lastElement.next = entry; // lastElement сслфаетя на текущий entry
        }

        lastElement = entry; // entry последний элемент
        size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);

        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E value = super.removeFirst();
        if (isEmpty()) {
            lastElement = null; // если список пустой то обнуляем нашу ссылку
        }
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
        if (current == lastElement && current == lastElement) {
            firstElement = lastElement = null;
        } else if (current == firstElement) {
            firstElement = current.next;

        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        size--;
        return true;
    }
}
