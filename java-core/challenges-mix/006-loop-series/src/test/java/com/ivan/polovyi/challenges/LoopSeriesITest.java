package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoopSeriesITest {
    @Test
    public void loopSeriesIITest(){
        int input[] = {5, 3, 5};
        int output[] = {8, 14, 26, 50, 98};


         assertTrue(Arrays.equals(output,LoopSeriesI.loopSeriesII(input)));
    }

}