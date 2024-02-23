package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ZoneDateTimeTest {

    @Test
    void create() {
        ZonedDateTime dateTime = ZonedDateTime.now();
        ZonedDateTime dateTime1 = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime time = ZonedDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(5));

        System.out.println(dateTime);
        System.out.println(dateTime1);
        System.out.println(time);

        ZonedDateTime time1 = ZonedDateTime.parse("2004-07-23T08:02:03+02:12[Asia/Jakarta]");

        System.out.println(time1);

    }

    @Test
    void changeTimeZone() {
        ZonedDateTime time = ZonedDateTime.now();
        ZonedDateTime time1 = time.withZoneSameLocal(ZoneId.of("GMT"));
        ZonedDateTime time2 = time.withZoneSameInstant(ZoneId.of("GMT"));

        System.out.println(time);
        System.out.println(time1);
        System.out.println(time2);
    }
}
