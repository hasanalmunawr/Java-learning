package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

    @Test
    void testCreate() {
        // memebuat calnder
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);

        //membuat date dari calnder
        Date date = calendar.getTime();
        System.out.println(date);
    }

    @Test
    void testManipulasi() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2004);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 23);

        Date date = calendar.getTime();
        System.out.println(date);


    }
    @Test
    void testGetDateCalnder() {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

    }
}
