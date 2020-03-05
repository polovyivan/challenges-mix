package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private static Fibonacci fibonacci;
    private static int[] expectedFibonacciSeries;

    @BeforeAll
    public static void setUp() {
        fibonacci = new Fibonacci();
        expectedFibonacciSeries = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
    }

    @Test
    void fibonacciMyVersionTest() {

        int[] resultFibonacciSeries = fibonacci.fibonacciMyVersion(expectedFibonacciSeries.length);

        assertTrue(Arrays.equals(expectedFibonacciSeries, resultFibonacciSeries));
    }


    @Test
    void fibonacciRecursion() {

        int[] resultFibonacciSeries = fibonacci.fibonacciRecursion(expectedFibonacciSeries.length);

        assertTrue(Arrays.equals(expectedFibonacciSeries, resultFibonacciSeries));
    }

    @Test
    void fibonacciRecursionWithoutArithmeticOverflow() {

        BigInteger[] expected = Arrays.stream(expectedFibonacciSeries)
                .mapToObj(BigInteger::valueOf)
                .toArray(BigInteger[]::new);

        BigInteger[] resultFibonacciSeries = fibonacci.fibonacciRecursionWithoutArithmeticOverflow(expected.length);

        assertTrue(Arrays.equals(expected, resultFibonacciSeries));
    }


    @Test
    void fibonacciJava8Test() {
        int[] resultFibonacciSeries = fibonacci.fibonacciJava8(expectedFibonacciSeries.length);

        assertTrue(Arrays.equals(expectedFibonacciSeries, resultFibonacciSeries));
    }
}
