package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberTest {

    @Test
    void testNumberFormat() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String format = numberFormat.format(10000000.255);
        System.out.println(format);
    }

    @Test
    void testNumberIndonesiaFormat() {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        String format = numberFormat.format(10000000.255);
        System.out.println(format);
    }
    @Test
    void testNumberJapansFormat() {
        Locale locale = new Locale("ja", "JP");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        String format = numberFormat.format(10000000.255);
        System.out.println(format);
    }

    @Test
    void testParsingindonesiaFromat() {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        try {
            double format = numberFormat.parse("10000000.255").doubleValue();
            System.out.println(format);
        } catch (ParseException e) {
            System.out.println(e.getErrorOffset());
        }
    }
     @Test
    void testParsingjapansFromat() {
        Locale locale = new Locale("ja", "JP");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        try {
            double format = numberFormat.parse("10000000.255").doubleValue();
            System.out.println(format);
        } catch (ParseException e) {
            System.out.println(e.getErrorOffset());
        }
    }

}
