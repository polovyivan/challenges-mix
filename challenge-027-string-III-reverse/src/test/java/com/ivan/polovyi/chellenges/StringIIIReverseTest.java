package com.ivan.polovyi.chellenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringIIIReverseTest {

    @Test
    void isStringPalindrome() {
        String input = "madam1";
        String expected = "Yes";
        assertEquals(expected, StringIIIReverse.isStringPalindrome(input));
    }
}