package com.ivan.polovyi.chellanges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairsOfSocksTest {


    @Test
    public void pairOfSocksTest() {

        int n = 3;
        int[] ar = {1, 1, 3};

        int n2 = 8;
        int[] ar2 = {1, 1, 1, 3, 3, 2, 4, 4};

        //template1
        assertEquals(1, PairsOfSocks.sockMerchantTemplate1(n, ar));
        assertEquals(3, PairsOfSocks.sockMerchantTemplate1(n2, ar2));

        //template2
        assertEquals(1, PairsOfSocks.sockMerchantTemplate2(n, ar));
        assertEquals(3, PairsOfSocks.sockMerchantTemplate2(n2, ar2));

        //template3
        assertEquals(1, PairsOfSocks.sockMerchantTemplate3(n, ar));
        assertEquals(3, PairsOfSocks.sockMerchantTemplate3(n2, ar2));
    }

}