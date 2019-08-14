package lesson_2.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class ArrayImplTest {

    private ArrayImpl<Integer> array;

    @BeforeEach
    public void prepare() {
        array = new ArrayImpl<>();
    }

    @Test
    public void testAdd() {
        array.add(1);
        array.add(2);
        array.add(3);

        Assertions.assertArrayEquals(
                new Integer[]{1, 2, 3},
                array.getArray());
    }

    @Test
    public void remove() {
        array.add(1);
        array.add(2);
        array.add(3);

        array.remove(2);
        Assertions.assertArrayEquals(
                new Integer[] {1, 3},
                array.getArray());
    }

    @Test
    public void indexOf() {

        Assertions.assertArrayEquals(
                new Integer[]{1, 2, 3},
                array.getArray());
    }
}