package com.ivan.polovyi.challenges;

import java.util.Scanner;

public class IpRegex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(regexCall(IP));
        }

    }

    public static boolean regexCall(String IP) {
        return IP.matches(new MyRegex().pattern);
    }

    private static class MyRegex {

        private static final String ZERO_TO_255
                = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

        public String pattern
                = ZERO_TO_255 + "\\." + ZERO_TO_255 + "\\."
                + ZERO_TO_255 + "\\." + ZERO_TO_255;

    }
}
