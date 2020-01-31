package com.ivan.polovyi.challenges;


import java.util.Scanner;
import java.util.regex.Pattern;

public class StringRegex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            checkPattern(in.nextLine());
        }
    }

    public static String checkPattern(String pattern) {

        try {
            Pattern.compile(pattern);
            return "Valid";

        } catch (Exception e) {
            return "Invalid";
        }
    }
}
