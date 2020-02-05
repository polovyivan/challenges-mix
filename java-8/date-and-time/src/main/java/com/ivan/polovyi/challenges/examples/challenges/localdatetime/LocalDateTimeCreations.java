package com.ivan.polovyi.challenges.examples.challenges.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeCreations {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime localDateTimeOf
                = LocalDateTime.of(2020, 10, 7, 12, 10);
        System.out.println("localDateTimeOf = " + localDateTimeOf);

        LocalDateTime localDateTimeOfLocalDateAndLocalTime
                = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("localDateTimeOfLocalDateAndLocalTime = " + localDateTimeOfLocalDateAndLocalTime);


        // get value
        int localDateTimeHour = localDateTime.getHour();
        System.out.println("localDateTimeHour = " + localDateTimeHour);

        int getHourUsingChronoField = localDateTime.get(ChronoField.HOUR_OF_DAY);
        System.out.println("getHourUsingChronoField = " + getHourUsingChronoField);


        // modifying values
        LocalDateTime localDateTimePlus = localDateTime.plusHours(2);
        System.out.println("localDateTimePlus = " + localDateTimePlus);


    }
}
