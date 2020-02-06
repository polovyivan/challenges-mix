package com.ivan.polovyi.callenges.collections.iterable.collection.queue.deque.array;

import java.util.ArrayDeque;

public class ArrayDequeExample {

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);
        arrayDeque.add(4);
        arrayDeque.add(4);
        arrayDeque.add(8);
        arrayDeque.add(7);
        try {
            arrayDeque.add(null);
        } catch (NullPointerException e) {
            System.out.println("e = " + e);
        }

        System.out.println("arrayDeque = " + arrayDeque);

        // does not have an additional methods
    }
}
