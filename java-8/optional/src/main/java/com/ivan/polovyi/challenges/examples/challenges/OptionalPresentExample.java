package com.ivan.polovyi.challenges.examples.challenges;

import java.util.Optional;

/*
 -- isPresent() -
 -- ifPresent() -
 */
public class OptionalPresentExample {
    public static void main(String[] args) {
        // isPresent()
        Optional<String> optional = Optional.ofNullable("hello optional");
        System.out.println("optional.isPresent() = " + optional.isPresent());
        Optional<String> optionalNull = Optional.ofNullable(null);
        System.out.println("optional.isPresent() = " + optionalNull.isPresent());
        if(optional.isPresent()){
            System.out.println("optional = " + optional.get());
        }

        // ifPresent()
        optional.ifPresent(s-> System.out.println(s));
        optionalNull.ifPresent(s-> System.out.println(s));


    }
}
