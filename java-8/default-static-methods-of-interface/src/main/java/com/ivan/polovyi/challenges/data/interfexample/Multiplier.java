package com.ivan.polovyi.challenges.data.interfexample;

import java.util.List;

public interface Multiplier {

    int multiply(List<Integer> intList);

    default int size(List<Integer> intList) {

        return intList.size();
    }

    static boolean isEmpty(List<Integer> intList) {

        return intList.isEmpty();
    }
}
