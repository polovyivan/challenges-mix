package com.ivan.polovyi.challenges;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Always check duration of execution
 */
public class WhenNotToUseParallelStreams {

    public static void main(String[] args) {


        List<Integer> integerList = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(Collectors.toList());
        sequentialStream(integerList);

        parallelStream(integerList);

    }

    private static void sequentialStream(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        integerList.stream()
                .reduce(0, (x, y) -> x + y);
        long endTime = System.currentTimeMillis();

        System.out.println("sequential " + (endTime - startTime));
    }

    private static void parallelStream(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        integerList.stream()
                .parallel()
                .reduce(0, (x, y) -> x + y);
        long endTime = System.currentTimeMillis();

        System.out.println("parellel " + (endTime - startTime));
    }
}
