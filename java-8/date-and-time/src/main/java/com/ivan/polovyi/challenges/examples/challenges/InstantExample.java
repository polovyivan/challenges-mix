package com.ivan.polovyi.challenges.examples.challenges;

import java.time.Duration;
import java.time.Instant;

/*
Instant class: -- represent time in a machine readable format
               -- represent time in a seconds from January 01 1970 (EPOCH) to current time
 */
public class InstantExample {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        long epochSecond = instant.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);

        Instant instant0 = Instant.ofEpochSecond(0);
        System.out.println("instant0 = " + instant0);

        Duration between = Duration.between(instant, instant0);
        System.out.println("between = " + between.getNano());
    }
}
