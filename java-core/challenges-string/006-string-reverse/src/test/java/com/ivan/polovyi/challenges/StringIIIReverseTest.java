package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringIIIReverseTest {

    @Test
    void isStringPalindrome() {
        String input = "madam";
        String expected = "Yes";
        assertEquals(expected, StringIIIReverse.isStringPalindrome(input));
    }
}