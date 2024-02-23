package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest {

    @Test
    void createLocalDateTime() {
        LocalDate Ld = LocalDate.of(2004, 07, 23);
        LocalTime Lt = LocalTime.of(10, 35);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(Ld, Lt);
        // bisa menggunakan parse juga

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }

    @Test
    void changeLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withYear(2004).withMonth(7);

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }

    @Test
    void getLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());

        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
    }

    @Test
    void konfersiToDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
    }

}
