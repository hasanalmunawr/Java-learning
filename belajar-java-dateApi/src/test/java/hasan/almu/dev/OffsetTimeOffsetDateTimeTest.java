package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.*;

public class OffsetTimeOffsetDateTimeTest {

    @Test
    void createTest() {
        OffsetTime time = OffsetTime.now();
        OffsetTime time2 = OffsetTime.of(LocalTime.now(), ZoneOffset.ofHours(4));


        System.out.println(time);
        System.out.println(time2);

        OffsetDateTime dateTime = OffsetDateTime.now();
        OffsetDateTime dateTime1 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(12));

        System.out.println(dateTime);
        System.out.println(dateTime1);
    }

    @Test
    void conversionFromNonOffset() {
        LocalTime localTime = LocalTime.now();
        OffsetTime offsetTime = localTime.atOffset(ZoneOffset.ofHours(4));
        LocalTime localTime1 = OffsetTime.now().toLocalTime();

        System.out.println(localTime);
        System.out.println(offsetTime);
        System.out.println(localTime1);

        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(5));
        LocalDateTime localDateTime1 = OffsetDateTime.now().toLocalDateTime();

        System.out.println(localDateTime);
        System.out.println(offsetDateTime);
        System.out.println(localDateTime1);

        LocalTime localTime2 = offsetDateTime.toLocalTime();
        LocalDate localDate = offsetDateTime.toLocalDate();

        System.out.println(localTime2);
        System.out.println(localDate);
    }
}
