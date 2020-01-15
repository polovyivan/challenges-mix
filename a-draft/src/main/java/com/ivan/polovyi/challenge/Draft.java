package com.ivan.polovyi.challenge;

import java.util.*;
import java.io.*;


class Draft {
    public static void main(String[] argh) {


        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        System.out.println(t);
        long tempVar = t < 0 ? t * (-1) : t;
        System.out.println(t);
        for (int i = 0; i < tempVar; i++) {

            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                //Complete the code
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }
}



