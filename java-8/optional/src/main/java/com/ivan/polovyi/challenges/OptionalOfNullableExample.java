package com.ivan.polovyi.challenges;

import java.util.Optional;

/*
  -- ofNullable() - used if outcome can be null value
  -- of() - if null gives an exception
  -- empty() - gives empty optional as a result can use in an exception block
   */

public class OptionalOfNullableExample {


    public static void main(String[] args) {
        System.out.println(ofNullable().get());

        System.out.println(of());

        System.out.println(empty());


    }

    private static Optional<String> ofNullable() {

        return Optional.ofNullable("Hello world");
    }

    private static Optional<String> of() {

        return Optional.of("Hello world");
    }

    private static Optional<String> empty() {

        return Optional.empty();
    }
}
