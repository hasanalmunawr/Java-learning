package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PahrsingFormatingTest {

    @Test
    void parsingWithDateTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");

        LocalDate date = LocalDate.parse("2023 07 23",timeFormatter);

        System.out.println(date);
    }
     @Test
    void formating() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate date = LocalDate.parse("2023 07 23",timeFormatter);
        String format = date.format(timeFormatter);

         System.out.println(format);
        System.out.println(date);
    }
    @Test
    void defaultFormating() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate date = LocalDate.parse("2023 07 23",timeFormatter);
        String format = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

         System.out.println(format);
        System.out.println(date);
    }

    @Test
    void i18n() {
        Locale indo = new Locale("id", "ID");

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd", indo);
        LocalDate localDate = LocalDate.now();
        String format = localDate.format(timeFormatter);

        System.out.println(format);
    }

    @Test
    void testPharsing() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter IndoensiaFormat = DateTimeFormatter.ofPattern("2023 07 23", Locale.of("id", "ID"));
//        LocalDate date = LocalDate.parse("2004 07 23", IndoensiaFormat);

        LocalDate date = LocalDate.now();
        String format = date.format(IndoensiaFormat);
        System.out.println(format);
    }
}
