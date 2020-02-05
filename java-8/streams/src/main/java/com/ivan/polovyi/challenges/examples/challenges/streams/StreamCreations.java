package com.ivan.polovyi.challenges.examples.challenges.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamCreations {

    public static void main(String[] args) {

        //Factory method
        ofMethod();
        //Factory method
        inereteMethod();
        //Factory method
        generateMethod();

        streamFromArray();

        createStreamUsingBuilder();

    }


    private static void ofMethod() {
        Stream<String> streamOf = Stream.of("Ivan", "Cris", "Miguel");
        streamOf.forEach(System.out::println);
    }

    private static void inereteMethod() {
        // creates infinite stream
        // first param seed is a starting point
        Stream<Integer> integerStream = Stream.iterate(1, x -> x * 2);
        integerStream
                //if no limit will reach int max value and than will print zeros
                .limit(10)
                .forEach(System.out::println);
    }

    private static void generateMethod() {
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void streamFromArray() {
        String[] arr = {"Ivan", "Cris", "Miguel"};
        Stream<String> streamFromArray = Arrays.stream(arr);
        streamFromArray.forEach(System.out::println);
    }


    private static void createStreamUsingBuilder() {
        // Create stream using Stream builder()
        Stream.Builder<String> builder
                = Stream.builder();

        // Adding elements in the stream of Strings
        Stream<String> stream = builder.add("a")
                .add("b")
                .add("c")
                .build();
    }

}
