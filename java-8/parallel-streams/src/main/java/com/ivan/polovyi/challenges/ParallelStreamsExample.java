package com.ivan.polovyi.challenges;

import java.util.function.Supplier;
import java.util.stream.IntStream;

/*
Parallel streams:
 -- splits data in multiple parts
 -- process them parallelly
 -- combine result
 -- uses Fork/Join framework

 */
public class ParallelStreamsExample {
    public static void main(String[] args) {

        System.out.println("Number of processors :"+Runtime.getRuntime().availableProcessors());
        System.out.println("Sequential " + checkPerformance(ParallelStreamsExample::sequentialStream, 20));
        System.out.println("Parallel " + checkPerformance(ParallelStreamsExample::parallelStream, 20));
    }


    private static int sequentialStream() {
        return IntStream.rangeClosed(1, 100)
                .sum();
    }


    private static int parallelStream() {
        return IntStream.rangeClosed(1, 100)
                .parallel()
                .sum();
    }


    public static long checkPerformance(Supplier<Integer> supplier, int numberOfTimes) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfTimes; i++) {
            sequentialStream();
            parallelStream();
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
