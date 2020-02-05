package com.ivan.polovyi.challenges.examples.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(createToken2(s));// Write your code here.
        createToken2(s);
        scan.close();
    }

    public static void createToken(String s) {
        s = s.trim();

        if (s.length() > 400000) {
            System.out.print("");
        } else if (s.length() == 0) {
            System.out.print(0);
        } else {
            String arr[] = s.split("[ !,?._'@]+");
            System.out.println(arr.length);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static String createToken2(String s) {
        String result = "";
        int count = 0;
        String[] split = s.split("[^A-Za-z0-9]");


        for (int i = 0; i < split.length; i++) {

            if (split[i] != null && !split[i].isEmpty()) {
                result += split[i];
                count++;

                if (i == split.length - 1) {
                    return count + "\n" + result;
                }
                result += "\n";
            }
        }

        return result;
    }

}
