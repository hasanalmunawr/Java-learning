package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class LegalicyTest {

    @Test
    void konvensiToNewLegalicy() {
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant);

        Calendar calendar = Calendar.getInstance();
        Instant instant1 = calendar.toInstant();
        System.out.println(instant1);

        TimeZone timeZone =TimeZone.getDefault();
        ZoneId zoneId = timeZone.toZoneId();
        System.out.println(zoneId);

    }

    @Test
    void konvensiNewToLegacy() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);

        Calendar calendar = GregorianCalendar.from(zonedDateTime);
        System.out.println(calendar);

        ZoneId zoneId = ZoneId.systemDefault();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(timeZone);
    }
}
