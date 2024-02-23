package hasanalmu.CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

public class FormatTest {

    @Test
    void excel() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.EXCEL.builder().setHeader("FirstName", "lastName", "Value").build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("hasan", "almunawar", 90);
        printer.printRecord("hasin", "newer", 40);

        String value = writer.getBuffer().toString();
        System.out.println(value);
    }
      @Test
    void mongoDB() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.MONGODB_CSV.builder().setHeader("FirstName", "lastName", "Value").build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("hasan", "almunawar", 90);
        printer.printRecord("hasin", "newer", 40);

        String value = writer.getBuffer().toString();
        System.out.println(value);
    }
  @Test
    void mySql() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.MYSQL.builder().setHeader("FirstName", "lastName", "Value").build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("hasan", "almunawar", 90);
        printer.printRecord("hasin", "newer", 40);

        String value = writer.getBuffer().toString();
        System.out.println(value);
    }
 @Test
    void postrSQL() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.POSTGRESQL_CSV.builder().setHeader("FirstName", "lastName", "Value").build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("hasan", "almunawar", 90);
        printer.printRecord("hasin", "newer", 40);

        String value = writer.getBuffer().toString();
        System.out.println(value);
    }
@Test
    void tab() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.TDF.builder().setHeader("FirstName", "lastName", "Value").build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("hasan", "almunawar", 90);
        printer.printRecord("hasin", "newer", 40);

        String value = writer.getBuffer().toString();
        System.out.println(value);
    }



}
