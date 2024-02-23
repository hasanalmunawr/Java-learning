package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class LocalTimeTest {

    @Test
    void CreateLocalTest() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(12, 32);
        LocalTime localTime2 = LocalTime.parse("12:21");



        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void modifyLocalTime() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.withHour(23).withMinute(11);
        LocalTime localTime2 = localTime.withMinute(59);

        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void getLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
    }

    @Test
    void modifyPlusMinus() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.plusHours(5);
        LocalTime localTime2 = localTime.minusMinutes(59);

        System.out.println(localTime1);
        System.out.println(localTime2);

    }
}
