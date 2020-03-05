package com.ivan.polovyi.challenges;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
0 1 1 2 3 5 8 13 21 34
 */
public class Fibonacci {

    public static void main(String[] args) {


    }

    public static int[] fibonacciMyVersion(int number) {

        int[] fibonacciSeries = new int[number];

        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;
        for (int i = 2; i < number; i++) {

            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }


        return fibonacciSeries;
    }

    public static int[] fibonacciRecursion(int number) {

        /*
        can cause:
        - arithmetic overflow - resolved by using BigInteger
        - stack overflow
         */

        class FibonacciRecursionUtil {
            int fibonacciRecursionCallee(int i) {
                if (i <= 1) return i;
                else return fibonacciRecursionCallee(i - 1) + fibonacciRecursionCallee(i - 2);
            }
        }
        int[] fibonacciSeries = new int[number];
        FibonacciRecursionUtil fibonacciRecursionUtil = new FibonacciRecursionUtil();
        for (int i = 0; i < number; i++) {

            fibonacciSeries[i] = fibonacciRecursionUtil.fibonacciRecursionCallee(i);
        }
        return fibonacciSeries;
    }


    public static BigInteger[] fibonacciRecursionWithoutArithmeticOverflow(int number) {


        class FibonacciRecursionUtil {
            BigInteger fibonacciRecursionCallee(BigInteger i) {
                if (i.equals(BigInteger.ZERO) || i.equals(BigInteger.ONE)) return new BigInteger(String.valueOf(i));
                else return fibonacciRecursionCallee(i.subtract(new BigInteger("1")))
                        .add(fibonacciRecursionCallee(i.subtract(new BigInteger("2"))));
            }
        }
        BigInteger[] fibonacciSeries = new BigInteger[number];
        FibonacciRecursionUtil fibonacciRecursionUtil = new FibonacciRecursionUtil();
        for (int i = 0; i < number; i++) {

            fibonacciSeries[i] = fibonacciRecursionUtil.fibonacciRecursionCallee(new BigInteger(String.valueOf(i)));
        }
        return fibonacciSeries;
    }


    public static int[] fibonacciJava8(int limit) {

        return Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(limit)
                .mapToInt(t -> t[0])
                .toArray();
    }

}
