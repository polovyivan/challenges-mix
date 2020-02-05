package com.ivan.polovyi.challenges.examples.challenges;

import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        char[] aArray = a.toUpperCase().toCharArray();
        char[] bArray = b.toUpperCase().toCharArray();


//        char[] distinctCharsArray = a.concat(b).chars()
//                .distinct()
//                .mapToObj(i -> (char) i)
//                .map(String::valueOf)
//                .collect(Collectors.joining())
//                .toCharArray();

        char[] chars = a.concat(b).toUpperCase().toCharArray();
        String disting = "";


        for (int c = 0; c < chars.length; c++) {
            if (!disting.contains(String.valueOf(chars[c]))) {
                disting+=String.valueOf(chars[c]);
            }
        }

        char[] distinctCharsArray = disting.toCharArray();


        for (int i = 0; i < distinctCharsArray.length; i++) {
            int counterA = 0;
            int counterB = 0;
            for (int j = 0; j < aArray.length; j++) {
                if (distinctCharsArray[i] == aArray[j]) {
                    counterA++;
                }
                if (distinctCharsArray[i] == bArray[j]) {
                    counterB++;
                }

            }
            if (counterA != counterB) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
