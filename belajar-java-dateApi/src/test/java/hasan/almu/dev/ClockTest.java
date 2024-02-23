package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ClockTest {

    @Test
    void createOclock() {

        Clock clock = Clock.system(ZoneId.of("GMT"));
        Clock clock1 = Clock.systemUTC();
        Clock clock2 = Clock.systemDefaultZone();

        System.out.println(clock);
        System.out.println(clock1);
        System.out.println(clock2);
    }

    @Test
    void getIsntanceInClock() throws InterruptedException {
        Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

        Instant instant = clock.instant();
        System.out.println(instant);
        Thread.sleep(1_0000);

        Instant instant1  = clock.instant();
        System.out.println(instant1);
        Thread.sleep(1_000);

    }

    @Test
    void createDateTimeFromClock() {
//        Year Yearmnoth, Localtime, lcaldate, ldatetieme, zonadatetim
        Clock clockJakarta = Clock.system(ZoneId.of("Asia/Jakarta"));

        Year ya  = Year.now(clockJakarta);
        YearMonth yearMonth = YearMonth.now(clockJakarta);
        LocalTime localTime = LocalTime.now(clockJakarta);
        LocalDate localDate = LocalDate.now(clockJakarta);
        LocalDateTime localDateTime = LocalDateTime.now(clockJakarta);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(clockJakarta);

        System.out.println(clockJakarta);
        System.out.println(ya);
        System.out.println(yearMonth);
        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);
    }
}
