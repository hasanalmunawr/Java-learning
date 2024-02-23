package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeTest {

    @Test
    void testDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMMM yyyy");
        String format = dateFormat.format(new Date());

        System.out.println(format);
    }
     @Test
    void testDateIndonesia() {
        String pattren = "EEE dd MMMM yyyy";
         Locale country = new Locale("in", "ID");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattren, country);
        String format = dateFormat.format(new Date());

        System.out.println(format);
    }
  @Test
    void testDateJepang() {
        String pattren = "EEE dd MMMM yyyy";
        Locale country = new Locale("ja", "JP");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattren, country);
        String format = dateFormat.format(new Date());

        System.out.println(format);
    }

    @Test
    void testCan() {
        String pattern = "EEE dd MMMM yyyy";
        Locale country = new Locale("id", "ID");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, country);
        String format = dateFormat.format(new Date());
        System.out.println(format);
    }

    @Test
    void testDateFormatParseIndonesia() {
        String pattren = "EEE dd MMMM yyyy";
        var country = new Locale("id", "ID");
        var dateFormat = new SimpleDateFormat(pattren, country);

        try {
            var data = dateFormat.parse("Min 19 November 2023");
            System.out.println(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String format = dateFormat.format(new Date());
//        System.out.println(format);
    }
    @Test
    void testDateFormatParseJpn() {
        String pattren = "EEE dd MMMM yyyy";
        var country = new Locale("ja", "JP");
        var dateFormat = new SimpleDateFormat(pattren, country);

        try {
            var data = dateFormat.parse("日 19 11月 2023");
            System.out.println(data);
        } catch (ParseException e) {
            System.out.println("masage : " + e.getMessage());
            throw new RuntimeException(e);
        }

        String format = dateFormat.format(new Date());
//        System.out.println(format);/
    }
}
