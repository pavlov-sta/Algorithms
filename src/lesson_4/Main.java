package lesson_4;

import lesson_3.queue.Queue;
import lesson_3.stack.Stack;
import lesson_4.linkedlist.*;

public class Main {
    public static void main(String[] args) {
        //testSimpleLinkList();
        //testStack();
        //testTwoSideLinkedList();
        testQueue();

    }

    private static void testSimpleLinkList() {

        LinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));

        System.out.println("Size is " + linkedList.size());
        linkedList.display();

        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.removeFirst());
        }
    }

    private static void testStack() {
//        Stack<Integer> stack = new StackImpl<>(5);
        Stack<Integer> stack = new LinkedStackImpl<>();
        addToStack(stack, 1);
        addToStack(stack, 2);
        addToStack(stack, 3);
        addToStack(stack, 4);
        addToStack(stack, 5);
        addToStack(stack, 6);
        addToStack(stack, 7);
        addToStack(stack, 8);
        addToStack(stack, 9);
        addToStack(stack, 10);
        addToStack(stack, 11);


        System.out.println("Top of stack is: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
    }

    private static void testTwoSideLinkedList() {
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);//1
        linkedList.insertLast(2);//1 2
        linkedList.insertFirst(3);//3 1 2
        linkedList.insertLast(4);//3 1 2 4

        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));
        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Remove 2: " + linkedList.remove(2));

        System.out.println("Size is " + linkedList.size());
        linkedList.display();

        while (!linkedList.isEmpty()) {
            System.out.print(linkedList.removeFirst() + ", ");
        }
    }

    private static void addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
        }
    }

    private static void testQueue() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.insert(3);
        queue.insert(1);
        queue.insert(4);
        queue.insert(6);
        queue.insert(2);
        queue.insert(5);

        System.out.println("Top of queue is: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

}

