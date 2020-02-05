package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DequeueMaxNumOfUnicIntegersTest {

    private static long start;
    private static long durtion;

    @BeforeAll
    static public void start() {
        start = System.currentTimeMillis();
    }

    @AfterAll
    static public void end() {
        durtion = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start);
    }

    @Test
    void getUniqueNumbersFromDequeue() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(5);
        deque.offer(3);
        deque.offer(5);
        deque.offer(2);
        deque.offer(3);
        deque.offer(2);
        int n = 6;
        int m = 3;

        long expected = 3;

        assertEquals(expected, DequeueMaxNumOfUnicIntegers.getUniqueNumbersFromDequeue(n, m, deque));
        assertTrue(durtion <= 3);


        Deque <Integer> deque2 = new ArrayDeque<>();
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        deque2.offer(1);
        int n2 = 10;
        int m2 = 3;

        int expected2 = 1;
        assertEquals(expected2,DequeueMaxNumOfUnicIntegers.getUniqueNumbersFromDequeue(n2,m2,deque2));

    }
}