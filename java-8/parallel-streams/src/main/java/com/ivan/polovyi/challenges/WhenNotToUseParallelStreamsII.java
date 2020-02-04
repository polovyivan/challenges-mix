package com.ivan.polovyi.challenges;

import java.util.stream.IntStream;

public class WhenNotToUseParallelStreamsII {

    public static void main(String[] args) {
        Sum sum = new Sum();
        IntStream.rangeClosed(1,1000).forEach(sum::performSum);
        System.out.println("sequential "+sum.getTotal());


        // always return wrong results.
        // it change the same variable total multiple times from different threads
        IntStream.rangeClosed(1,1000).parallel().forEach(sum::performSum);
        System.out.println("parallel "+sum.getTotal());
    }


    static class Sum {

        private int total;


        public void performSum(int input) {
            total += input;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
