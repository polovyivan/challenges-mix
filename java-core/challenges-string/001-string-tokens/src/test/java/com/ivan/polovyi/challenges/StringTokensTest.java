package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTokensTest {

    @Test
    void createToken() {
        String input = "He is a very very good boy, isn't he?";
        String expected = "10\n" +
                "He\n" +
                "is\n" +
                "a\n" +
                "very\n" +
                "very\n" +
                "good\n" +
                "boy\n" +
                "isn\n" +
                "t\n" +
                "he";

        assertEquals(expected,StringTokens.createToken2(input));
    }
}