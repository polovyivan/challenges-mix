package com.ivan.polovyi.challenge;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BracketsPairsTest {


    @Test
    public void bracketsPairs() {

        String[] expected = {"YES"};
        String[] input = {"{([])}"};

        assertTrue(Arrays.equals(expected, BracketsPairs.checkBracketsPairs(input)));


    }


}