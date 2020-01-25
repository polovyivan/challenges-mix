package com.ivan.polovyi.challemges.examples;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MultithreadedCalculationTest {

    @Test
    void calculateResult() {

        BigInteger base1 = new BigInteger("100000");
        BigInteger power1 = new BigInteger("100000");
        BigInteger base2 = new BigInteger("55555555");
        BigInteger power2 = new BigInteger("50");

        BigInteger result = base1.pow(power1.intValue()).add(base2.pow(power2.intValue()));

        try {
            assertEquals(result, MultithreadedCalculation.calculateResult(base1, power1, base2, power2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}