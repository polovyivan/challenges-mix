package com.ivan.polovyi.challenges.examples.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    @Test
    void isAnagram() {
        String inputA = "anagram";
        String inputB = "margana";

        assertTrue(Anagrams.isAnagram(inputA, inputB));
    }
}