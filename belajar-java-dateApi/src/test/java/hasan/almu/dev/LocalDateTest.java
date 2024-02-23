package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateTest {

    @Test
    void CreateLocalDacte() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2004, Month.JULY, 23);
        LocalDate localDate2 = LocalDate.parse("2022-02-22");

        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    @Test
    void getLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getMonthValue());
        // dan lain lain
    }

    @Test
    void modifyLocalDate() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDateYears = localDate.withYear(1000);
        LocalDate localDateMonth = localDate.withMonth(8);
        LocalDate localDateDayof = localDate.withDayOfMonth(14);

        System.out.println(localDate);
        System.out.println(localDateYears);
        System.out.println(localDateMonth);
        System.out.println(localDateDayof);
        System.out.println(localDate.getDayOfYear());
    }

    @Test
    void modifyPlussMius() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.plusMonths(1);
        LocalDate localDate2 = localDate.minusYears(19);

        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println(localDate2);
    }
}
