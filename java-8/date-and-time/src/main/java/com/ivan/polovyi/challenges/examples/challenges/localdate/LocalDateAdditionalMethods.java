package com.ivan.polovyi.challenges.examples.challenges.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateAdditionalMethods {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        // subtract value from date

        LocalDate minusUsingChronoUnit = localDate.minus(1, ChronoUnit.DAYS);
        System.out.println("minusUsingChronoUnit = " + minusUsingChronoUnit);

        // check if date is a leap year
        boolean leapYear = localDate.isLeapYear();
        System.out.println("leapYear = " + leapYear);


        // check dates equality
        boolean localDateEqual = localDate.isEqual(LocalDate.now());
        System.out.println("localDateEqual = " + localDateEqual);

        // check if date is before or after another date
        boolean after = localDate.isAfter(LocalDate.of(2019, 12, 7));
        System.out.println("after = " + after);
        boolean before = localDate.isBefore(LocalDate.of(2019, 12, 7));
        System.out.println("before = " + before);


        // Unsupported
        //  LocalDate minusH = localDate.minus(1, ChronoUnit.HOURS);

        // Check if operation is supported
        boolean supported = localDate.isSupported(ChronoUnit.HOURS);
        System.out.println("supported = " + supported);


    }
}
