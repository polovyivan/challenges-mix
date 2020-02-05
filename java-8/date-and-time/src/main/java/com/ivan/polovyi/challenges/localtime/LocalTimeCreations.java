package com.ivan.polovyi.challenges.localtime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeCreations {
    public static void main(String[] args) {

        // create localTime
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);


        LocalTime localTimeOf = LocalTime.of(18, 20);
        System.out.println("localTimeOf = " + localTimeOf);


        // get value from localTime
        int localTimeHour = localTime.getHour();
        System.out.println("localTimeHour = " + localTimeHour);

        // get value from localTime using TemporalField
        int localHour = localTime.get(ChronoField.HOUR_OF_DAY);
        System.out.println("localHour = " + localHour);

        // represent time in seconds
        int toSecondOfDay = localTime.toSecondOfDay();
        System.out.println("toSecondOfDay = " + toSecondOfDay);

    }
}
