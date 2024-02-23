package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {

    @Test
    void create() {
        Period period = Period.of(2020, 7, 12);
        Period period1 = Period.ofYears(2004);
        Period period2 = Period.ofMonths(04);
        Period period3 = Period.ofDays(14);

        System.out.println(period);
        System.out.println(period1);
        System.out.println(period2);
        System.out.println(period3);
    }

    @Test
    void get() {
        Period period = Period.ofYears(2000);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    @Test
    void betwwen() {
        Period period = Period.between(LocalDate.now(), LocalDate.now().plusMonths(34));
        Period period1 = Period.between(LocalDate.of(2004, 07, 23), LocalDate.of(2023, 11, 23));

        System.out.println(period.getYears());
        System.out.println(period1.getYears());
    }
}
