package com.ivan.polovyi.challenges;

import java.util.Scanner;

public class StringIIIReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        System.out.println(isStringPalindrome(A));

    }

    public static String isStringPalindrome(String str) {


        // new StringBuilder(hi).reverse().toString();

        char[] reversedString = new char[str.length()];

        for (int i = 0, j = str.length() - 1; i < str.length() && j >= 0; i++, j--) {
            reversedString[i] = str.toCharArray()[j];
        }

        if (str.equals(new String(reversedString))) {
            return "Yes";
        } else
            return "No";

    }
}
