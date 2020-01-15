package com.ivan.polovyi.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypes {

    public static void main(String[] args) {

        long input = 2;

        checkInputDataType(input);
    }

    public static List<String> checkInputDataType(long x) {
        List<String> responces = new ArrayList<>();

        System.out.println(x + " can be fitted in:");


        if (x >= -9_22_372_036_854_775_808L && x <= 9_223_372_036_854_775_807L)
        // if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1) as an alternative
        {
            responces.add("* long");
            if (x >= -2_147_483_648 && x <= 2_147_483_647) {
                responces.add("* int");
                if (x >= -32_768 && x <= 32_767) {
                    responces.add("* short");
                    if (x >= -128 && x <= 127) {
                        responces.add("* byte");
                    }
                }
            }
        }
        Collections.reverse(responces);

        responces.forEach(System.out::println);

        return responces;


    }
}
