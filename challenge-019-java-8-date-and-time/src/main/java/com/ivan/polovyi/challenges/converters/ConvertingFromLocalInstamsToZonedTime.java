package com.ivan.polovyi.challenges.converters;

import java.time.*;

public class ConvertingFromLocalInstamsToZonedTime {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/Chicago"));
        System.out.println("zonedDateTime = " + zonedDateTime);

        ZonedDateTime zonedDateTimeInstance = Instant.now().atZone(ZoneId.of("America/Chicago"));
        System.out.println("zonedDateTimeInstance = " + zonedDateTimeInstance);

        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(-5));
        System.out.println("offsetDateTime = " + offsetDateTime);
    }
}
