package com.ivan.polovyi.challenges.examples.challenges.converters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ConvertingFromLocalToLocal {

    public static void main(String[] args) {

        // LocalDate -> LocalDateTime
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateSetTime = localDate.atTime(10, 15);
        System.out.println("localDateSetTime = " + localDateSetTime);

        // LocalTime -> LocalDateTime
        LocalTime localTime = LocalTime.now();
        LocalDateTime localTimeSetDate = localTime.atDate(LocalDate.of(2018, 01, 01));
        System.out.println("localTimeSetDate = " + localTimeSetDate);

        // LocalDateTime -> LocalDate
        LocalDate LocalDateTimeToLocalDate = localTimeSetDate.toLocalDate();
        System.out.println("LocalDateTimeToLocalDate = " + LocalDateTimeToLocalDate);

        // LocalDateTime -> LocalTime
        LocalTime localDateTimeToLocalTime = localTimeSetDate.toLocalTime();
        System.out.println("localDateTimeToLocalTime = " + localDateTimeToLocalTime);


    }

}
