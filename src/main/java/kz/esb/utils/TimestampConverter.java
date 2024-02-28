package kz.esb.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

public class TimestampConverter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static java.util.Calendar parseDateTime( String lexicalXSDDateTime ) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(lexicalXSDDateTime, formatter);
        return GregorianCalendar.from(zonedDateTime);
    }

    public static String printDateTime( java.util.Calendar val ) {
        LocalDateTime dt = LocalDateTime.ofInstant(val.toInstant(), ZoneId.of("GMT+6"));
        return formatter.format(dt);
    }
}
