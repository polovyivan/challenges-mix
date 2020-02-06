package com.ivan.polovyi.callenges.collections.iterable.collection.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(4);
        deque.add(8);
        deque.add(7);
        try {
            deque.add(null);
        } catch (NullPointerException e) {
            System.out.println("e = " + e);
        }

        System.out.println("deque = " + deque);


        // void addFirst(E e);

        // void addLast(E e);

        // boolean offerFirst(E e);

        // boolean offerLast(E e);

        //  E removeFirst();

        //  E removeLast();

        // E pollFirst();

        // E pollLast();

        // E getFirst();

        // E getLast();

        // E peekFirst();

        // E peekLast();

        //  boolean removeFirstOccurrence(Object o);

        //  boolean removeLastOccurrence(Object o);


    }
}
