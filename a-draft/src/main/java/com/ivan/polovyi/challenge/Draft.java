package com.ivan.polovyi.challenge;

import java.util.stream.Stream;

public class Draft {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int n = 5;

        Stream.iterate(1,i->i+(int) Math.pow(2, i) * b)
                .limit(n+1)
                .forEach(System.out::println);
    }
}
