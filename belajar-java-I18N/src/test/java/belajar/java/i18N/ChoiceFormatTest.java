package belajar.java.i18N;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChoiceFormatTest {

    @Test
    void testChoice() {
        var pattren = "-1#negatif | 0#kosong | 1#ada | 1<gacor ";
        ChoiceFormat choiceFormat = new ChoiceFormat(pattren);

        System.out.println(choiceFormat.format(-1));
        System.out.println(choiceFormat.format(0));
        System.out.println(choiceFormat.format(1));
        System.out.println(choiceFormat.format(2));

    }

    @Test
    void testChoiceBymessage() {
        var locale = new Locale("id", "ID");
        ResourceBundle bundle = ResourceBundle.getBundle("massage", locale);
        String format = bundle.getString("saldo");

        MessageFormat messageFormat = new MessageFormat(format, locale);
        var format1 = messageFormat.format(new Object[] {
                "hasan", 12, 12
        });
        System.out.println(format1);
    }

    @Test
    void testChoiceFormatUsa() {
        var usa = new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("massage", usa);
        String pattren = bundle.getString("saldo");

        MessageFormat messageFormat = new MessageFormat(pattren, usa);
        var format = messageFormat.format(new Object[]{
                "hasan", 120
        });
        System.out.println(format);
    }
}
