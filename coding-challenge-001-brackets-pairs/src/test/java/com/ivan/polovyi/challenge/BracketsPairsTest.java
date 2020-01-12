package com.ivan.polovyi.challenge;

import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BracketsPairsTest {


    @Test
    public void bracketsPairsFirstAttempt() {

        //first input check if even/odd verification works
        String[] expected1 = {"YES","NO"};
        String[] input1 = {"{([])}","([])}"};

        assertTrue(Arrays.equals(expected1, BracketsPairs.checkBracketsPairsFirstAttempt(input1)));


        //first input check if even/odd verification works
        String[] expected2 = {"YES","NO"};
        String[] input2 = {"{([])}","([])}"};

        assertTrue(Arrays.equals(expected2, BracketsPairs.checkBracketsPairsFirstAttempt(input2)));


        //first input check if even/odd verification works
        String[] expected3 = {"YES","NO","YES"};
        String[] input3 = {"{([])}","([])}","[[[[[{}]]]]]{}({}{})"};

        assertTrue(Arrays.equals(expected3, BracketsPairs.checkBracketsPairsFirstAttempt(input3)));


//        String[] expected4 = {"NO"};
//        String[] input4 = {"{)([]}"};
//
//        assertTrue(Arrays.equals(expected4, BracketsPairs.checkBracketsPairsFirstAttempt(input4)));


    }

    @Test
    public void bracketsPairsSecondAttempt() {

        //first input check if even/odd verification works
        String[] expected1 = {"YES","NO"};
        String[] input1 = {"{[()]}","{[(])}"};

        assertTrue(Arrays.equals(expected1, BracketsPairs.checkBracketsPairsSecondAttempt(input1)));




    }

}