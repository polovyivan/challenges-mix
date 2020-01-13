package com.ivan.polovyi.challenge;

import java.util.*;
import java.util.stream.Collectors;

public class PairOfSocks {

    public static void main(String[] args) {
        int n = 3;
        int[] ar = {1, 2, 3};

        sockMerchant(n, ar);
    }

    static int sockMerchant(int n, int[] ar) {

        int numberOfPairs = 0;

        // get set of color
        Set<Integer> colors = new HashSet<Integer>(Arrays.stream(ar).boxed().collect(Collectors.toList()));
        //count quantity of each color and save it to Map
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
}
