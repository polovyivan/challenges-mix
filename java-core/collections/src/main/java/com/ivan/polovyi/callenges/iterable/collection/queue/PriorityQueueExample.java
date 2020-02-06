package com.ivan.polovyi.callenges.iterable.collection.queue;

import java.util.PriorityQueue;

/*
allows duplicates
doesn't allow null
 */
public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(4);
        priorityQueue.add(8);
        priorityQueue.add(7);
        try {
            priorityQueue.add(null);
        } catch (NullPointerException e) {
            System.out.println("Does not allow null = " + e);
        }

        System.out.println("priorityQueue = " + priorityQueue);

        // does not have additional methods
    }
}
