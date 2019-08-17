package lesson_3.queue;

import lesson_3.stack.StackImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


public class QueueImplTest {

    private QueueImpl<Integer> queue;

    @BeforeEach
    public void prepare() {
        queue = new QueueImpl<>(5);
    }

    @Test
    public void insert() {

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        Assertions.assertArrayEquals(
                new Integer[]{10, 20, 30, 40, 50},
                queue.getQueue());
    }

    @Test
    public void remove() {
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.remove();
        queue.remove();
        queue.insert(60);
        queue.insert(50);

        Assertions.assertArrayEquals(
                new Integer[]{60, 50, 30, 40, 50},
                queue.getQueue());

    }

    @Test
    public void peek() {
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        Assertions.assertEquals(10, queue.peek());

    }
}