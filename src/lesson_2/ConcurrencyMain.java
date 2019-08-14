package lesson_2;

import lesson_2.array.Array;
import lesson_2.array.ArrayImpl;
import lesson_2.array.SortedArrayImpl;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.concurrent.TimeUnit;

public class ConcurrencyMain {
    private static final int ARRAY_CAPACITY = 5_00000;

    public static final int MAX_VALUE = 10_000;

    public static void main(String[] args) throws InterruptedException {
        Supplier<Array> constructor = ArrayImpl::new;
        //Supplier<Array> constructor = () -> ArrayImpl::new;

         //Supplier<Array> constructor = () -> SortedArrayImpl::new;
        Array arr1 = createArray(constructor);
        //Array arr1 = new ArrayImpl();
        Array arr2 = createArray(constructor);
        Array arr3 = createArray(constructor);

        randomIntialize(arr1, arr2, arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> tasks = List.of(
                measureTime(arr1::sortBubble, "Sort Bubble"),
                measureTime(arr1::sortSelect, "Sort Select"),
                measureTime(arr1::sortInsert, "Sort Insert")
        );

        for (Runnable task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static void randomIntialize(Array... arrays) {
        Random random = new Random();
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (Array array : arrays) {
                array.add(value);
            }
        }
    }

    private static Runnable measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.println(String.format("%s took time: %d micros. ",
                    actionName,
                    TimeUnit.NANOSECONDS.toMicros(duration)));
        };
    }

    private static Array createArray(Supplier<Array> factory) {
        return factory.get();
    }
}
