package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LoopSeriesITest {
    @Test
    public void loopSeriesIITest(){
        int input[] = {5, 3, 5};


         assertTrue(Arrays.equals(input,LoopSeriesI.loopSeriesII(input)));
    }

}