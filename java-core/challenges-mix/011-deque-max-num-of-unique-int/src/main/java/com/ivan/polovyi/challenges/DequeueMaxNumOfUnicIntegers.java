package com.ivan.polovyi.challenges;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DequeueMaxNumOfUnicIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            deque.add(in.nextInt());
        }
        System.out.println(getUniqueNumbersFromDequeue(n, m, deque));
    }

    public static long getUniqueNumbersFromDequeue(int n, int m, Deque<Integer> deque) {
        long max = 0;
        for (long i = 0; i < n - m + 1; i++) {

            List<Integer> uniqueNumbers = deque.stream()
                    .limit(m)
                    .distinct()
                    .collect(Collectors.toList());

            if (max < uniqueNumbers.size()) {
                max = uniqueNumbers.size();
            }
            deque.poll();
        }
        return max;
    }
}
