package lesson_2.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.*;

public class ArrayImplTest {
    private static final int LEN = 1000000;
    private  Array<Integer> array = new ArrayImpl<>(LEN);
    @Test
    public void add() {
        for (int i = 0; i < LEN; i++) {
            array.add(i);
        }
        Assert.assertEquals(2, array.size());
    }

    @Test
    public void remove() {
        array.add(5);
        array.add(3);
        Assert.assertEquals(true, array.remove(2));
    }

    @Test
    public void indexOf() {
        for (int i = 0; i < LEN; i++) {
            array.add(i+1);
        }
        Assert.assertEquals(5569, array.indexOf(5569));
    }
}