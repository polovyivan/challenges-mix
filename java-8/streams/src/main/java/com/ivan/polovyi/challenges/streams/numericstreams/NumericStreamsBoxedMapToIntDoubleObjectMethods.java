package com.ivan.polovyi.challenges.streams.numericstreams;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
-- boxed() - int -> Integer
-- mapToInt() - Integer -> IntStream
-- mapToLong() - numeric -> IntStream
-- mapToDouble() - numeric -> DoubleStream
-- mapToObj() - numeric -> to some object
 */
public class NumericStreamsBoxedMapToIntDoubleObjectMethods {

    public static void main(String[] args) {
        boxing();

        unboxing();

        mapToObject();

        mapToLong();

        mapToDouble();
    }

    private static void mapToDouble() {
        double sum = IntStream.rangeClosed(1, 10)
                .mapToDouble(i -> i)
                .sum();
        System.out.println("sum = " + sum);
    }


    private static void boxing() {
        List<Integer> boxed = IntStream.rangeClosed(1, 10)
                //int
                .boxed()
                //Integer
                .collect(Collectors.toList());
    }

    private static void unboxing() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntStream intStream = integerList.stream()
                //Integer
                .mapToInt(Integer::intValue);
        //return IntStream;
    }
    private static void mapToObject() {
        List<Integer> mappedToObj = IntStream.rangeClosed(1, 10)
                .mapToObj(n -> {
                    return new Integer(n);
                }).collect(Collectors.toList());
        System.out.println("mappedToObj = " + mappedToObj);
    }

    private static void mapToLong() {
        long sum = IntStream.rangeClosed(1, 10)
                .mapToLong(i -> i)
                .sum();
        System.out.println("sum = " + sum);
    }
}
