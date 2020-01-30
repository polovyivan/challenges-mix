package com.ivan.polovyi.challenges;

import java.util.Scanner;

public class StringI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(sumLengthsOfStrings(A, B));
        System.out.println(isALexicographicallyLarger(A, B));
        System.out.println(capitalizeLetterInString(A) + " " + capitalizeLetterInString(B));

    }


    public static int sumLengthsOfStrings(String a, String b) {

        return a.length() + b.length();
    }

    public static String isALexicographicallyLarger(String a, String b) {

        return a.compareTo(b) < 0 ? "No" : "Yes";

    }

    public static String capitalizeLetterInString(String str) {
        char[] chars = str.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
        //return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }
}
