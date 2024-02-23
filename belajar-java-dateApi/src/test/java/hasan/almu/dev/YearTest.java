package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.*;

public class YearTest {

    @Test
    void createYear() {
        Year year = Year.now();
        Year year1 = Year.of(2004);
        Year year2 = Year.parse("2003");

        System.out.println(year);
        System.out.println(year1);
        System.out.println(year2);

        YearMonth yearMonth = YearMonth.now();
        YearMonth yearMonth1 = YearMonth.of(2004, 7);
        YearMonth yearMonth2 = YearMonth.parse("2003-03");

        System.out.println(yearMonth);
        System.out.println(yearMonth1);
        System.out.println(yearMonth2);

        MonthDay monthDay = MonthDay.now();
        MonthDay monthDay1 = MonthDay.of(7, 23);
        MonthDay monthDay2 = MonthDay.parse("--07-23");

        System.out.println(monthDay);
        System.out.println(monthDay1);
        System.out.println(monthDay2);
    }

    @Test
    void converseYearToLocalDate() {
        Year year = Year.now();
        YearMonth yearMonth = year.atMonth(Month.JULY);
        LocalDate localDate = yearMonth.atDay(23);
        MonthDay monthDay = MonthDay.from(localDate);
        System.out.println(monthDay);

        Year year1 = Year.of(2004);
        LocalDate localDate1 = year1.atMonth(Month.JULY).atDay(23);
        MonthDay monthDay1 = MonthDay.from(localDate1);
        System.out.println(monthDay1);
    }

    @Test
    void getYearAndMonth() {
        Year year = Year.now();
        System.out.println(year.getValue());

        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth.getMonth());
        System.out.println(yearMonth.getMonthValue());
    }
}
