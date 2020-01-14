package com.ivan.polovyi.coding.challenges;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class OutputFormating {


    public static void main(String[] args) {

        String[] input = {"java 100", "cpp 65", "python 50"};
        sysOut(input);
    }

    static void sysOut(String[] input) {

        //Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < input.length; i++) {

            String [] array = input[i].split(" ");

            System.out.printf("%-10.10s  %-3.3s%n", array[0],
                    String.format("%03d",Integer.valueOf(array[1])));

        }
        System.out.println("================================");
    }
}
