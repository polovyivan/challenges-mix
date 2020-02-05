package com.ivan.polovyi.challenges;

public class LoopSeriesI {

    public static void main(String[] args) {

        int input[] = {5, 3, 5};


        loopSeriesII(input);

    }

    public static int[] loopSeriesII(int[] input) {

        int a = input[0];//5
        int b = input[1];//3
        int n = input[2];//5
        int result[] = new int[n];

        int tenpVar = a;
        for (int i = 0; i < n; i++) {

            tenpVar += (int) Math.pow(2, i) * b;
            result[i] = tenpVar;
        }

        return result;
    }


}

