package com.ivan.polovyi.challenges.examples.challenges.data.interfexample;

import java.util.Arrays;

public class MultipierClient {
    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();
        int multiply = multiplier.multiply((Arrays.asList(1, 2, 3, 5)));
        System.out.println("multiply = " + multiply);

        int size = multiplier.size(Arrays.asList(1, 2, 3, 5));
        System.out.println("size = " + size);

        boolean empty = Multiplier.isEmpty(Arrays.asList(1, 2, 3, 5));
        System.out.println("empty = " + empty);

    }
}
