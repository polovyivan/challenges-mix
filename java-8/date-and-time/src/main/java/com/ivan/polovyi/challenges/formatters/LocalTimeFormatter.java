package com.ivan.polovyi.challenges.formatters;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeFormatter {
    public static void main(String[] args) {
        parseLocalTime();
        formatLocalTime();

    }


    private static void parseLocalTime() {
        String time = "13:00";
        LocalTime localTimeParsedFromString = LocalTime.parse(time);

        LocalTime localTimeWithFormatter = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("localTimeWithFormatter = " + localTimeWithFormatter);

        // custom defined format
        String timeCustom = "13*00";
        DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("HH*mm");
        LocalTime parseCustom = LocalTime.parse(timeCustom, dtForm);
        System.out.println("parseCustom = " + parseCustom);


        String timeSec = "13*00*01";
        DateTimeFormatter dtFormSec = DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime timeSecCustom = LocalTime.parse(timeSec, dtFormSec);
        System.out.println("timeSecCustom = " + timeSecCustom);
    }

    private static void formatLocalTime() {

        DateTimeFormatter dtFormSec = DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime localTime = LocalTime.now();
        String format = localTime.format(dtFormSec);
        System.out.println("format = " + format);
    }
}
