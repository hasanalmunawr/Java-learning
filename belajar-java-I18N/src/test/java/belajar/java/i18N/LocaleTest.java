package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LocaleTest {

    @Test
    void testLocale() {
        var language = "id";
        var country = "ID";
        var locale = new Locale(language, country);

        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());

    }
}
