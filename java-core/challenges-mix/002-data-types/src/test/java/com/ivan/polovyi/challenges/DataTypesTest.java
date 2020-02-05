package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class DataTypesTest {

    @Test
    public void dataTypesTest() {
        long inputAll = 1;
        List<String> expectedAll = Arrays.asList("* byte", "* short", "* int", "* long");
        assertIterableEquals(expectedAll, DataTypes.checkInputDataType(inputAll));

        long inputInt = -9_22_372_036_854_775_808L;
        List<String> expectedInt = Arrays.asList("* long");
        assertIterableEquals(expectedInt, DataTypes.checkInputDataType(inputInt));

    }

}