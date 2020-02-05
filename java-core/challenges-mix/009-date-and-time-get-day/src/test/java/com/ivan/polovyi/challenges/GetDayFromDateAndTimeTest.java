package com.ivan.polovyi.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetDayFromDateAndTimeTest {

    @Test
    void findDay() {

        int month = 8;

        int day = 5;

        int year = 2015;

        String result = "WEDNESDAY";

        assertEquals(result, GetDayFromDateAndTime.findDayPriorToJava8(month, day, year));

        assertEquals(result, GetDayFromDateAndTime.findDayJava8(month, day, year));
    }
}