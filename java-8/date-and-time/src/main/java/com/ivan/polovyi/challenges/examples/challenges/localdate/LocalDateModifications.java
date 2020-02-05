package com.ivan.polovyi.challenges.examples.challenges.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateModifications {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        // increment local day (it return another instance of LocalDate
        LocalDate localDatePlus2Day = localDate.plusDays(2);
        System.out.println("localDatePlus2Day = " + localDatePlus2Day);

        LocalDate localDatePlus2Month = localDate.plusMonths(2);
        System.out.println("localDatePlus2Month = " + localDatePlus2Month);

        // decrement local day (it return another instance of LocalDate
        LocalDate localDateMinus2Days = localDate.minusDays(2);
        System.out.println("localDateMinus2Days = " + localDateMinus2Days);

        // modify date using method with[value]()
        LocalDate localDateWithYear = localDate.withYear(2021);
        System.out.println("localDateWithYear = " + localDateWithYear);

        // modify date using method with using with() passing temporal fields from Temporal enum
        LocalDate withChronofield = localDate.with(ChronoField.YEAR, 2030);
        System.out.println("withChronofield = " + withChronofield);

        // modify date using method with using with() passing temporal fields from TemporalAdjusters class
        LocalDate withFirstDayOfNextMonth = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("withFirstDayOfNextMonth = " + withFirstDayOfNextMonth);

    }
}
