package com.ivan.polovyi.challenges.function;

/*
-- extends Function used when input and output hav the same type
-- extends Function used when inputs and output hav the same type
 */

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperatorInterfaceExample {
    public static void main(String[] args) {

        UnaryOperator<String> unOp = s -> s.concat("default");
        System.out.println(unOp.apply("Java8"));


        BinaryOperator<Integer> multiplication = (a, b) -> a * b;
        System.out.println("multiplication.apply(5,2) = " + multiplication.apply(5, 2));

        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("maxBy.apply(10,5) = " + maxBy.apply(10, 5));

        BinaryOperator<Integer> mibBy = BinaryOperator.minBy(comparator);
        System.out.println("mibBy.apply(10,5) = " + mibBy.apply(10, 5));

    }
}
