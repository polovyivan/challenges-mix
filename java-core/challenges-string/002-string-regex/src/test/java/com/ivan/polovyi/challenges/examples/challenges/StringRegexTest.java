package com.ivan.polovyi.challenges.examples.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRegexTest {

    @Test
    void checkPattern() {
        String input1 = "([A-Z])(.+)";
        String expected1 = "Valid";

        assertEquals(expected1,StringRegex.checkPattern(input1));


        String input2 = "batcatpat(nat";
        String expected2 = "Invalid";
        assertEquals(expected2,StringRegex.checkPattern(input2));


    }
}