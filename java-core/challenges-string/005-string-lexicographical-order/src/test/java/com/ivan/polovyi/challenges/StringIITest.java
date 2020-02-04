package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringIITest {

    @Test
    void getSmallestAndLargest() {
        String inputWord = "welcometojava";
        int inputSubstring = 3;

        String expected = "ava" + "\n" + "wel";

        assertEquals(expected, StringII.getSmallestAndLargest(inputWord, inputSubstring));
    }
}