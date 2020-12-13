package com.example.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Utils {
	private Utils() {
    }

    public static LocalDateTime retrieveDateNowWithSaoPauloZoneID() {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
    
    public static LocalDate extractDateFromPattern(final String date, final DateTimeFormatter pattern) {
        return LocalDate.parse(date, pattern);
 
    }

}
