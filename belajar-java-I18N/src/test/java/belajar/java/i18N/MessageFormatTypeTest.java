package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTypeTest {

    @Test
    void testFormatType() {
        var locale = new Locale("id", "ID");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("massage", locale);
        String format = resourceBundle.getString("status");

        MessageFormat messageFormat = new MessageFormat(format, locale); // kunci nay
        var formatNew = messageFormat.format(new Object[] {
                "hasan", new Date(), 10000
        });
        System.out.println(formatNew);
    }

    @Test
    void testMessageFormatTypeUs() {
        var us = new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("massage", us);
        String formatMassage = bundle.getString("status");
        MessageFormat messageFormat = new MessageFormat(formatMassage, us);
        var format = messageFormat.format(new Object[]{
                "hasan", new Date(), 1000
        });
        System.out.println(format);
    }
}
