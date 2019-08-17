package lesson_2;

import lesson_2.array.Array;
import lesson_2.array.ArrayImpl;

public class Main {

    public static void main(String[] args) {
        int len = 1000000;
        Array<Integer> array = new ArrayImpl<>(len);
        for (int i = 0; i < len; i++) {
            int random = (int) (Math.random() * i);
            array.add(random);
        }
        /*array.display();
        array.sortInsert();
        array.display();
        System.out.println("Remove 3:" + array.remove(Integer.valueOf(len)));

        System.out.println("Find 1: " + array.indexOf(5682));
        System.out.println("Find 5: " + array.indexOf(len));*/
        long a = System.currentTimeMillis();
        //array.display();
        System.out.println("Время заполнения массива: " + (System.currentTimeMillis() - a) + " мс\n");
        array.sortBubble();
        System.out.println("Время sortBubble массива: " + (System.currentTimeMillis() - a) + " мс\n");
        //array.sortSelect();
        //System.out.println("Время sortSelect массива: " + (System.currentTimeMillis() - a) + " мс\n");
        //array.sortInsert();
        //array.display();
        //System.out.println("Время sortInsert массива: " + (System.currentTimeMillis() - a) + " мс\n");

    }
}
