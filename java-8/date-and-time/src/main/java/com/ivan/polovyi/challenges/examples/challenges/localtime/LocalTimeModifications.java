package com.ivan.polovyi.challenges.examples.challenges.localtime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeModifications {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);

        LocalTime localTimeMinusHours = localTime.minusHours(1);
        System.out.println("localTimeMinusHours = " + localTimeMinusHours);

        LocalTime minusChronoUnit = localTime.minus(1, ChronoUnit.HOURS);
        System.out.println("minusChronoUnit = " + minusChronoUnit);

        // change time to midnight
        LocalTime withMidnight = localTime.with(LocalTime.MIDNIGHT);
        System.out.println("withMidnight = " + withMidnight);

        LocalTime localTimeWithHour = localTime.withHour(22);
        System.out.println("localTimeWithHour = " + localTimeWithHour);


    }
}
