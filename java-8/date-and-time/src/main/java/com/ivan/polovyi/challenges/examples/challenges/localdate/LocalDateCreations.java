package com.ivan.polovyi.challenges.examples.challenges.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.Era;
import java.time.temporal.ChronoField;

public class LocalDateCreations {
    public static void main(String[] args) {

        // current date
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        // create custom date object from input
        LocalDate dateOf = LocalDate.of(2020, 07, 17);
        System.out.println("dateOf = " + dateOf);

        // create date from year and day number in a day
        LocalDate ofYearDay = LocalDate.ofYearDay(2020, 360);
        System.out.println("ofYearDay = " + ofYearDay);


        // read (get) values from date using get[value]()

        // get month name
        Month month = localDate.getMonth();
        System.out.println("month = " + month);

        // get month value
        int monthValue = localDate.getMonthValue();
        System.out.println("monthValue = " + monthValue);

        // get day of the week
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        // get day of the year
        int dayOfYear = localDate.getDayOfYear();
        System.out.println("dayOfYear = " + dayOfYear);

        // get era
        Era era = localDate.getEra();
        System.out.println("era = " + era);


        // read (get) values from date using get() passing temporal fields from Temporal enum
        int dayOfWeekChrono = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println("dayOfWeekChrono = " + dayOfWeekChrono);
        // ...
    }
}
