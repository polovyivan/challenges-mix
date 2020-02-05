package com.ivan.polovyi.challenges;

import java.util.Scanner;

public class StaticInitializerBlock {
    static boolean flag;
    static int B;
    static int H;

    static {
        flag = procces();
    }

    private static boolean procces() {

        Scanner s = new Scanner(System.in);

        String[] input = new String[2];
        for (int i = 0; i < 2; i++) {
            input[i] = s.nextLine();
        }
        B = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        if (B < 0 || H < 0) {

            try {
                throw new Exception("Breadth and height must be positive");
            } catch (Exception e) {
                System.err.println(e.toString());
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
