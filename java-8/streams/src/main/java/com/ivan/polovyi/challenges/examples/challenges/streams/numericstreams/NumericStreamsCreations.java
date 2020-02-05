package com.ivan.polovyi.challenges.examples.challenges.streams.numericstreams;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
-- IntStream
-- LongStream
-- DoubleStream

   methods:
   - IntStream.range(1,50) - returns int stream with 1 to 49
   - IntStream.rangeClosed(1,50) - returns int stream with 1 to 50
   - LongStream.range(1,50) - returns long stream with 1 to 49
   - LongStream.rangeClosed(1,50) - returns long stream with 1 to 50
    do not have this method for double can be used Int(Long)Stream....asDoubleStream

 */
public class NumericStreamsCreations {
    public static void main(String[] args) {

        whyWeNeedIntStreams();

        rengeRengeClosedMethods();

    }


    private static void whyWeNeedIntStreams() {
        // why we need Int...Streams
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        intList.stream()
                .reduce(0, (x, y) -> x + y);// performs unboxing operation

        System.out.println("intList = " + intList);

        int sum = IntStream.rangeClosed(1, 6)
                .sum();
        System.out.println("sum = " + sum);
    }

    private static void rengeRengeClosedMethods() {
        long countRange = IntStream.range(1, 50)
                .count();
        System.out.println("countRange = " + countRange);

        long countRangeClosed = IntStream.rangeClosed(1, 50)
                .count();
        System.out.println("countRangeClosed = " + countRangeClosed);
    }
}
