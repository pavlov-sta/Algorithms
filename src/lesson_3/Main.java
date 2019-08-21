package lesson_3;

import lesson_3.dek.DequeImpl;
import lesson_3.queue.Queue;
import lesson_3.queue.QueueImpl;
import lesson_3.stack.Stack;
import lesson_3.stack.StackImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        /*Stack<Integer> stack = new StackImpl<>(5);
        addToStack(stack, 1);
        addToStack(stack, 5);
        addToStack(stack, 8);
        addToStack(stack, 2);
        addToStack(stack, 7);

        System.out.print("Top of stack is:" + stack.peek()+ "\n");

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+"; "); // извлекаем элементы
        }
        System.out.println("\n");
        Queue<Integer> queue = new QueueImpl<>(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.remove();
        queue.remove();
        System.out.println("Top of queue is: " + queue.peek());
        queue.insert(60);
        queue.insert(50);

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + ", ");
        }
        System.out.println("\n");
         //2. Создать программу, которая переворачивает вводимые строки (читает справа налево) c применением стека или очереди.
        String string = "2. Создать программу, которая переворачивает вводимые строки (читает справа налево) c применением стека или очереди.";
        flipOver(string);
        System.out.println("\n");*/

        // 3. Создать класс для реализации дека.
        DequeImpl<Integer> deque = new DequeImpl(5);
        deque.insertRight(30);
        deque.insertRight(50);
        deque.insertRight(10);
        deque.insertLeft(20);
        deque.insertLeft(10);
        while( !deque.isEmpty() )
        {
            System.out.print(deque.removeLeft() + " ");
        }
        System.out.println("");
    }

    private static void addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
        }
    }

    private static void flipOver(String string) {

        char[] chars = string.toCharArray();

        Stack stack = new StackImpl(chars.length);
        for (char oneChar : chars){
            stack.push(oneChar);
        }

        while (!stack.isEmpty()){
            System.out.print((char) stack.pop());
        }
    }

}

