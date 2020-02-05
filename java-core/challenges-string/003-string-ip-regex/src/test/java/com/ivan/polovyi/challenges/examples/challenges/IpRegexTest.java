package com.ivan.polovyi.challenges.examples.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IpRegexTest {

    @Test
    void regexCall() {
        String input1 = "000.12.12.034";

        assertTrue(IpRegex.regexCall(input1));

        String input2 = "00.12.123.123123.123";

        assertFalse(IpRegex.regexCall(input2));
    }
}