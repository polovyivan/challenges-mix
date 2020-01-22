package com.ivan.polovyi.challenges.data.interfexample;

import java.util.List;

public class MultiplierImpl implements Multiplier {
    @Override
    public int multiply(List<Integer> intList) {
        return intList.stream()
                .reduce(1, (x, y) -> x * y);
    }
}
