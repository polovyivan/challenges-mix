package com.ivan.polovyi.challenges.zoneddateandtime;

import java.time.*;
import java.util.Set;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);

        ZoneOffset offset = zonedDateTime.getOffset();
        System.out.println("offset = " + offset);

        String zoneId = zonedDateTime.getZone().getId();
        System.out.println("zoneId = " + zoneId);

        // list of zone ids
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
        System.out.println(availableZoneIds.size());

        // get USA time zone
        ZonedDateTime zonedDateTimeChicago = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("zonedDateTimeChicago = " + zonedDateTimeChicago);

        ZonedDateTime zonedDateTimeUsingClock
                = ZonedDateTime.now(Clock.system(ZoneId.of("America/Chicago")));
        System.out.println("zonedDateTimeUsingClock = " + zonedDateTimeUsingClock);


        // using LocalDateTime by passing ZonedId (does not have offset and timezone name)
        LocalDateTime localDateTimeUsingZonedId = LocalDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("localDateTimeUsingZonedId = " + localDateTimeUsingZonedId);

        // using LocalDateTime by passing Clock (does not have offset and timezone name)
        LocalDateTime localDateTimeUsingClock = LocalDateTime.now(Clock.system(ZoneId.of("America/Chicago")));
        System.out.println("localDateTimeUsingClock = " + localDateTimeUsingClock);

        // using Instant
        LocalDateTime localDateTimeInstant = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Chicago"));
        System.out.println("localDateTimeInstant = " + localDateTimeInstant);


    }
}
