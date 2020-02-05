package com.ivan.polovyi.challenges.examples.challenges.converters;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ConvertingFromUtilSQLToLocal {

    public static void main(String[] args) {

        // java.util.Date -> LocalDate
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime = " + localDateTime);

        //LocalDate -> java.util.Date
        Date dateFromLocalDate = new Date().from(instant);
        System.out.println("dateFromLocalDate = " + dateFromLocalDate);

        Date dateFromLocalDate2 = new Date().from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("dateFromLocalDate2 = " + dateFromLocalDate2);

        // LocalDate -> java.sql.Date
        java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());
        System.out.println("sqlDate = " + sqlDate);

        // java.sql.Date -> LocalDate
        LocalDate sqlToLocalDate = sqlDate.toLocalDate();
        System.out.println("sqlToLocalDate = " + sqlToLocalDate);

    }
}
