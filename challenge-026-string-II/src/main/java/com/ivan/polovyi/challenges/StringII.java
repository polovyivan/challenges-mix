package com.ivan.polovyi.challenges;

import java.util.Scanner;

public class StringII {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String substrings[] = new String[s.length() - k + 1];

        for (int i = 0; i < s.length() - k + 1; i++) {
            substrings[i] = s.substring(i, i + k);
        }

        String temp = null;
        for (int i = 0; i < substrings.length; i++) {

            for (int j = i + 1; j < substrings.length; j++) {
                if (substrings[i].compareTo(substrings[j]) > 0) {
                    temp = substrings[i];
                    substrings[i] = substrings[j];
                    substrings[j] = temp;
                }

            }

        }
        smallest = substrings[0];
        largest = substrings[substrings.length - 1];

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
