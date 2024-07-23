package com.colls;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
// import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        
        // Date date;

        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));
        System.out.println(Instant.now());
        // Instant.now
    }
    
}
