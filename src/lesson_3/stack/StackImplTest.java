package lesson_3.stack;
//1. Реализовать рассмотренные структуры данных в консольных программах (или протестировать с JUnit).
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class StackImplTest {

    private StackImpl<Integer> stack;

    @BeforeEach
    public void prepare() {
        stack = new StackImpl<>(5);
    }

    @Test
    public void push() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        Assertions.assertArrayEquals(
                new Integer[]{10, 20, 30},
                stack.getSatck());
    }

    @Test
    public void pop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.pop();
        Assertions.assertArrayEquals(
                new Integer[]{10, 20, 30},
                stack.getSatck());

    }

    @Test
    public void peek() {
        stack.push(10);
        Assertions.assertEquals(10, stack.peek());
        stack.push(20);
        Assertions.assertEquals(20, stack.peek());
        stack.push(30);
        Assertions.assertEquals(30, stack.peek());
        stack.push(40);

        Assertions.assertEquals(30, stack.peek());

    }
}