package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    @Test
    void testCurrencyIndonesia() {
        Locale country = new Locale("id", "ID");
        Currency currency = Currency.getInstance(country);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(country));
    }
    @Test
    void testCurrencyUsa() {
        Locale country = new Locale("en", "US");
        Currency currency = Currency.getInstance(country);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(country));
    }
    @Test
    void testCurrencyJapan() {
        Locale country = new Locale("ja", "JP");
        Currency currency = Currency.getInstance(country);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(country));
    }

    @Test
    void testCurrencyByIndonesia() {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        try {
            double format = numberFormat.parse("Rp1.000.000").doubleValue();
            System.out.println(format);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testCurrencyUs() {
        Locale Us = new Locale("en", "US");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Us);

        try {
            var formt = numberFormat.parse("$1,100").doubleValue();
            System.out.println(formt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
