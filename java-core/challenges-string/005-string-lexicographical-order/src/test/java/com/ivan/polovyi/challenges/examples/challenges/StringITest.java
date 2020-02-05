package com.ivan.polovyi.challenges.examples.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringITest {

    @Test
    void sumLengthsOfStrings() {
        String inputA = "hello";
        String inputB = "java";
        int expected = inputA.length() + inputB.length();

        assertEquals(expected, StringI.sumLengthsOfStrings(inputA, inputB));
    }

    @Test
    void isALexicographicallyLarger() {
        String inputA = "hello";
        String inputB = "java";
        String expected = "No";
        assertEquals(expected, StringI.isALexicographicallyLarger(inputA, inputB));
    }

    @Test
    void capitalizeLetterInString() {

        String inputA = "hello";
        String inputB = "java";
        String expectedA = "Hello";
        String expectedB = "Java";
        assertEquals(expectedA, StringI.capitalizeLetterInString(inputA));
        assertEquals(expectedB, StringI.capitalizeLetterInString(inputB));
    }
}