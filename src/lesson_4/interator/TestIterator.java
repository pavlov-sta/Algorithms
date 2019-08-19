package lesson_4.interator;

import lesson_4.linkedlist.LinkedList;
import lesson_4.linkedlist.SimpleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
//        for (int i = 0; i < array.length; i++) {
//            int value = array[i];
//            doAction(value);
//        }
/*
        int index = 0;
        while (index < array.length) {
            int value = array[index];
            doAction(value);
            index++;
        }*/

//        Iterator<Integer> iterator = null;
//        while (iterator.hasNext()) {
//            Integer value = iterator.next();
//            doAction(value);
//        }

        System.out.println("----");

        LinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);

       /* for (int value : linkedList) {
            doAction(value);
        }*/

       /* while (!linkedList.isEmpty()) {
            Integer value = linkedList.removeFirst();
            doAction(value);
        }*/

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        for (Integer value : arrayList) {
            doAction(value);
        }

        List<Integer> jdkLinkedList = new java.util.LinkedList<>();
        jdkLinkedList.add(1);
        jdkLinkedList.add(2);
        jdkLinkedList.add(3);

        for (Integer value : jdkLinkedList) {
            doAction(value);
        }


    }

    public static void doAction(int value) {
        System.out.println(value);
    }

}
