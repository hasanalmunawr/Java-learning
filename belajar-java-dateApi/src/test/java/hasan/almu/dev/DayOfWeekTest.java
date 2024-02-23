package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

public class DayOfWeekTest {

    @Test
    void Create() {
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        var day1 =  dayOfWeek.plus(3);
        var day2 = dayOfWeek.minus(5);

        System.out.println(dayOfWeek);
        System.out.println(day1);
        System.out.println(day2);
    }
}
