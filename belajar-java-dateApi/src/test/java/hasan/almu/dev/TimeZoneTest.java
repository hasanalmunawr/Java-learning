package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {

    @Test
    void createTimeZone() {
        TimeZone timeZone = TimeZone.getDefault();//waktu saat ini di os
        TimeZone timeZoneJKT = TimeZone.getTimeZone("Asia/Jakarta");
        System.out.println(timeZoneJKT);

        String[] timeZone1 = TimeZone.getAvailableIDs();
        Arrays.asList(timeZone1).forEach(s -> System.out.println(s));

    }

    @Test
    void datezone() {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
    }

    @Test
    void getTimeZoneinCalender() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar1.get(Calendar.HOUR_OF_DAY));

        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

        System.out.println(calendar);
    }
}
