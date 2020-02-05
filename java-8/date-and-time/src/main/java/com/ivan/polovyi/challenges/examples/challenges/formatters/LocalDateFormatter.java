package com.ivan.polovyi.challenges.examples.challenges.formatters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

/*
 -- parse - convert a String to a LocalDate/LocalTime/LocalDateTime
 -- format - convert a LocalDate/LocalTime/LocalDateTime to String

 -- ISO_LOCAL_DATE - 2011-12-31 - default format
 -- ISO
 */
public class LocalDateFormatter {
    public static void main(String[] args) {

        parseStringToLocalDate();

        convertLocalDateToString();


    }


    private static void parseStringToLocalDate() {

        // using predefined formatter
        String dateFormat = "2020-01-22";
        LocalDate parsedDate = LocalDate.parse(dateFormat);
        System.out.println("parsedDate = " + parsedDate);

        // using formatter
        LocalDate parsedDateUsingFormatter = LocalDate.parse(dateFormat, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("parsedDateUsingFormatter = " + parsedDateUsingFormatter);

        String date2 = "20180401";
        LocalDate parsedDateUsingFormatter2 = LocalDate.parse(date2, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("parsedDateUsingFormatter2 = " + parsedDateUsingFormatter2);

        // using custom formatter
        String customDate = "2018|04|01";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDateCustomFormatter = LocalDate.parse(customDate, dateTimeFormatter);
        System.out.println("localDateCustomFormatter = " + localDateCustomFormatter);

    }

    private static void convertLocalDateToString() {

        LocalDate localDate = LocalDate.now();
        String stringOfDate = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("stringOfDate = " + stringOfDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        String stringOfDateCustome = localDate.format(dateTimeFormatter);
        System.out.println("stringOfDateCustome = " + stringOfDateCustome);


    }

}
