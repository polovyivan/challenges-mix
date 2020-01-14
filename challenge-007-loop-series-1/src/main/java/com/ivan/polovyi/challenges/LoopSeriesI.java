package com.ivan.polovyi.challenges;

public class LoopSeriesI {

    public static void main(String[] args) {

        int input[] = {5, 3, 5};


        loopSeriesII(input);

    }

    public static int[] loopSeriesII(int[] input) {

        int a = input[0];
        int b = input[1];
        int n = input[2];
        int result[] = new int[n+1];


        for (int i = 1;i<=n;i++){

            result[i]=result[i]+i*b;
        }

        System.out.println(result);
        return result;
    }


}

