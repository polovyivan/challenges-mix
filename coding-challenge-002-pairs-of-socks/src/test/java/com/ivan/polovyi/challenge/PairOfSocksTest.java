package com.ivan.polovyi.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairOfSocksTest {


    @Test
    public void pairOfSocksTest(){

        int n = 3;
        int[] ar = {1, 1, 3};

        assertEquals(2,PairOfSocks.sockMerchant(n,ar));

    }

}