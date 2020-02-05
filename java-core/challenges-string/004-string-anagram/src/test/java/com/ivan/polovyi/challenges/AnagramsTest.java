package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramsTest {

    @Test
    void isAnagram() {
        String inputA = "anagram";
        String inputB = "margana";

        assertTrue(Anagrams.isAnagram(inputA, inputB));
    }
}