package com.ivan.polovyi.challenges;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/*
Duration:
      -- time-based representation of time in Hours, Minutes, Seconds, Nanoseconds
      -- compatible with LocalTime and LocalDateTime only!!!
      -- represents a duration of time
      -- used to calculate difference between 2 times (between())
 */
public class DurationComparingTimes {

    public static void main(String[] args) {

        LocalTime localTime1 = LocalTime.of(7, 20);
        LocalTime localTime2 = LocalTime.of(9, 30);

        long untilDurationHours = localTime1.until(localTime2, ChronoUnit.HOURS);
        System.out.println("untilDurationHours = " + untilDurationHours);

        Duration between = Duration.between(localTime1, localTime2);
        System.out.println("between.toHours() = " + between.toHours());


        Duration durationOf10Hours = Duration.ofHours(10);
        System.out.println("durationOf10Hours.toMinutes() = " + durationOf10Hours.toMinutes());


    }
}