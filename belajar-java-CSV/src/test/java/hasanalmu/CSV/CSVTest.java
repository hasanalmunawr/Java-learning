package hasanalmu.CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVTest {

    @Test
    void createCSV() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("hasan", "almunawar", 90);
        printer.printRecord("hasin", "newer", 40);

        String value = writer.getBuffer().toString();
        System.out.println(value);
    }

    @Test
    void readCSV() throws IOException {
        Path path = Path.of("sample.csv");

        BufferedReader bufferedReader = Files.newBufferedReader(path);
        CSVParser parser = new CSVParser(bufferedReader, CSVFormat.DEFAULT);
        for(CSVRecord record : parser) {
            System.out.println("First Name : " + record.get(0));
            System.out.println("Last Name : " + record.get(1));
            System.out.println("Value : " + record.get(2));
        }
    }


    @Test
    void createCSVWithHeader() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader("FirstName", "lastName", "Value").build();

        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("hasan", "almunawar", 90);
        printer.printRecord("hasin", "newer", 40);

        String value = writer.getBuffer().toString();
        System.out.println(value);
    }

    @Test
    void readCSVWithHeader() throws IOException {
        Path path = Path.of("sample.csv");
        BufferedReader bufferedReader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First Name", "Last Name", "Value").build();
        CSVParser parser = new CSVParser(bufferedReader, format);
        for(CSVRecord record : parser) {
            System.out.println("First Name : " + record.get("First Name"));
            System.out.println("Last Name : " + record.get("Last Name"));
            System.out.println("Value : " + record.get("Value"));
        }

    }
}
