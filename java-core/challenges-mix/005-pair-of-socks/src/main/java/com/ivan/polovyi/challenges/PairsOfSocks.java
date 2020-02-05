package com.ivan.polovyi.challenges;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PairsOfSocks {

    public static void main(String[] args) {
        int n = 3;
        int[] ar = {1, 2, 3};

        sockMerchantTemplate1(n, ar);
    }

    static int sockMerchantTemplate1(int n, int[] ar) {
        return colorsCount(ar, removeDuplicatesUsingSet(ar));
    }

    static int sockMerchantTemplate2(int n, int[] ar) {
        return colorsCount(ar, removeDuplicatesOldSchool(ar));
    }

    static int sockMerchantTemplate3(int n, int[] ar) {
        return colorsCount(ar, removeDuplicatesJava8Stream(ar));
    }

    private static int colorsCount(int[] ar, List<Integer> colors) {
        Map<Integer, Integer> colorsQty = new HashMap<Integer, Integer>();

        for (Integer color : colors) {

            int colorCount = 0;

            for (int i = 0; i < ar.length; i++) {

                if (color == ar[i]) {
                    colorCount++;
                }

            }
            // divide quantity of each color by %2 and
            if (colorCount > 1) {
                colorsQty.put(color, colorCount / 2);
            }
        }

        //sum up all and return
        return colorsQty.values().stream().reduce(0, Integer::sum);
    }


    private static List<Integer> removeDuplicatesJava8Stream(int[] ar) {

        return IntStream.of(ar)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
    }


    private static List<Integer> removeDuplicatesUsingSet(int[] ar) {
        return new ArrayList<Integer>(new HashSet<Integer>(Arrays.stream(ar).boxed().collect(Collectors.toList())));
    }


    private static List<Integer> removeDuplicatesOldSchool(int[] ar) {

        List<Integer> distinct = new ArrayList<>();

        for (int number : ar) {

            if (!distinct.contains(number)) {
                distinct.add(number);
            }
        }
        return distinct;
    }

}
