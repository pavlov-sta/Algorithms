package lesson_4.interator;

import lesson_4.linkedlist.LinkedList;
import lesson_4.linkedlist.SimpleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
      /*  int[] array = {1, 2, 3};*/
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

       // System.out.println("----");


       /* while (!linkedList.isEmpty()) {
            Integer value = linkedList.removeFirst();
            doAction(value);
        }*/

      /*  List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        /*for (Integer value : arrayList) {
            doAction(value);
        }*/

       /* List<Integer> jdkLinkedList = new java.util.LinkedList<>();
        jdkLinkedList.add(1);
        jdkLinkedList.add(2);
        jdkLinkedList.add(3);
*/
      /*  for (Integer value : jdkLinkedList) {
            doAction(value);
        }*/

        LinkedList<Integer> list = new SimpleLinkedList<>();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        displayAll(list);

        System.out.println("-----------");

       /* ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();
       /* iterator.reset();//1! 2 3 4
        iterator.insertAfter(11);//1 11! 2 3 4*/
    //    iterator.next();//1 11 2! 3 4
    //    iterator.remove();//1 11 3! 4
        //iterator.insertBefore(0);// 1 11 0! 3 4
/*
        displayAll(list);
        System.out.println("-----------");

        iterator = (ListIterator<Integer>) list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            displayAll(list);
            System.out.println("-----------");
        }*/


    }

    public static void doAction(int value) {
        System.out.println(value);
    }

    private static void displayAll(LinkedList<Integer> list) {
        for (Integer value : list) {
            System.out.println(value);
        }
    }

}
