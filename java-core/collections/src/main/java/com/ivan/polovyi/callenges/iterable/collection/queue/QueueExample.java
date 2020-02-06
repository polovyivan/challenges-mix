package com.ivan.polovyi.callenges.iterable.collection.queue;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        // queue.add(null); java.lang.NullPointerException
        System.out.println("queue = " + queue);
        // boolean offer(E e); adds to the end of queue
        boolean offer = queue.offer(6);
        System.out.println("offer = " + offer);
        System.out.println("queue = " + queue);

        // E element() Retrieves, but does not remove, the head of this queue.
        Integer element = queue.element();
        System.out.println("element = " + element);
        System.out.println("queue = " + queue);

        Queue<Integer> emptyQueue = new ArrayDeque<>();
        try {
            emptyQueue.element();
        } catch (NoSuchElementException e) {
            System.out.println("e = " + e);
        }

        //  E poll() gets first element and removes it from from queue
        Integer poll = queue.poll();
        System.out.println("poll = " + poll);
        System.out.println("queue = " + queue);

        // E peek() Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        Integer peek = queue.peek();
        System.out.println("peek = " + peek);
        System.out.println("queue = " + queue);
    }


}
