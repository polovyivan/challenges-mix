package com.ivan.polovyi.challenges;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodExample {

    public static void main(String[] args) {
        /*
        Use case - sort list of names in alphabetical order
         */

        List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");

        // prior java 8
       // Collections.sort(stringList);
        System.out.println("stringList = " + stringList);

        // Java8
        stringList.sort(Comparator.naturalOrder());
        System.out.println("stringList = " + stringList);

        stringList.sort(Comparator.reverseOrder());
        System.out.println("stringList = " + stringList);

    }
}
