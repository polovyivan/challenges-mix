package com.ivan.polovyi.challenges.formatters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {
    public static void main(String[] args) {
        parseLocalDateTime();

        formatLocalDateTime();
    }

    private static void parseLocalDateTime() {
        String time = "2020-01-22T15:44:33";

        LocalDateTime localDateTime = LocalDateTime.parse(time);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime localDateTimeISOLocal = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("localDateTimeISOLocal = " + localDateTimeISOLocal);

        // custom date time format
        String customFormat = "2020-01-22T15|44|33";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH|mm|ss");
        LocalDateTime parse = LocalDateTime.parse(customFormat, dateTimeFormatter);
        System.out.println("parse = " + parse);

        String customFormat2 = "2020-01-22abc15|44|33"; // abc will be replaced with T
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss");
        LocalDateTime parse2 = LocalDateTime.parse(customFormat, dateTimeFormatter);
        System.out.println("parse2 = " + parse2);


    }

    private static void formatLocalDateTime() {

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'abc'HH|mm|ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(dateTimeFormatter2);
        System.out.println("format = " + format);
    }


}
