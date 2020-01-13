package com.ivan.polovyi.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairOfSocksTest {


    @Test
    public void pairOfSocksTest() {

        int n = 3;
        int[] ar = {1, 1, 3};

        assertEquals(1, PairOfSocks.sockMerchant(n, ar));


        int n2 = 8;
        int[] ar2 = {1, 1, 1, 3, 3, 2, 4, 4};

        assertEquals(3, PairOfSocks.sockMerchant(n2, ar2));

    }

}