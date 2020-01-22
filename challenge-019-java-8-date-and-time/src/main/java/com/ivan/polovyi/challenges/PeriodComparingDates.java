package com.ivan.polovyi.challenges;


import java.time.LocalDate;
import java.time.Period;

/*
Period:
      -- date-based representation of time in Days, Month, Years
      -- compatible with LocalDate only!!!
      -- represents a period of time
      -- used to calculate difference between 2 dates (between())
 */
public class PeriodComparingDates {

    public static void main(String[] args) {

        LocalDate localDate1 = LocalDate.of(2018, 01, 01);
        LocalDate localDate2 = LocalDate.of(2018, 12, 31);

        Period until = localDate1.until(localDate2);
        System.out.println("untilDays = " + until.getDays()); // just compares days only
        System.out.println("untilMonth = " + until.getMonths());
        System.out.println("untilYears = " + until.getYears());


        Period periodOfDays = Period.ofDays(10);
        System.out.println("Creation periodOfDays = " + periodOfDays);

        Period period = Period.of(1, 2, 3);
        System.out.println("period = " + period);

        Period between = Period.between(localDate1, localDate2);
        System.out.println("Calculate period between = " + between.getDays());


    }
}
