package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MasageFormatTest {

    @Test
    void testMassageFormat() {
        String pattren = "hai {0}, selamat datang di {1}";
        MessageFormat messageFormat = new MessageFormat(pattren);
        String format = messageFormat.format(new Object[]{"hasan", "google"});
        System.out.println(format);
    }

    @Test
    void testmessagebundel() {
        Locale indoensia = new Locale("id", "ID");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("massage", indoensia);
        String format = resourceBundle.getString("welcome.message");

        MessageFormat messageFormat = new MessageFormat(format);
        String formatou = messageFormat.format(new Object[]{"hasan", "youtube"});
        System.out.println(formatou);
    }
     @Test
    void testmessagebundelUS() {
        Locale Us = new Locale("en", "US");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("massage", Us);
        String format = resourceBundle.getString("welcome.message");

        MessageFormat messageFormat = new MessageFormat(format);
        String formatou = messageFormat.format(new Object[]{"hasan", "programer cama"});
        System.out.println(formatou);
    }

    @Test
    void testIndonesiaMessage() {
        Locale indonesia = new Locale("id", "ID");
        ResourceBundle bundle = ResourceBundle.getBundle("massage", indonesia);
        String format = bundle.getString("sentence.message");

        MessageFormat messageFormat = new MessageFormat(format);
        String h = messageFormat.format(new Object[] {
                "hasan", "jambi", "jogja", "deva"
        });
        System.out.println(h);
    }
    @Test
    void testUSMessage() {
        Locale usa = new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("massage", usa);
        String format = bundle.getString("sentence.message");

        MessageFormat messageFormat = new MessageFormat(format);
        String newFormat = messageFormat.format(new Object[] {
                "hasan", "sumatra", "new york", "kayla"
        });
        System.out.println(newFormat);
    }

}
