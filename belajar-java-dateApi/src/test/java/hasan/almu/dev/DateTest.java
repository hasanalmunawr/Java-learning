package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Objects;

public class DateTest {

    @Test
    void testCreate() {
        Date date1 = new Date();
        Date date2 = new Date(System.currentTimeMillis());

        System.out.println(date1);
        System.out.println(date2);
    }

    @Test
    void DateTest() {
        Date date = new Date();
        System.out.println(date);
    }


}
