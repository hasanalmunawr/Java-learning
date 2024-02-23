package hasanalmu.CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CreateSukaSuka {

    @Test
    void create() throws IOException {
        Path path = Path.of("Contoh.csv");
        StringWriter writer = new StringWriter();
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("hasan", "Jambi", "Backend");
        printer.printRecord("almu", "Jambi", "Frontend");

        String value = writer.getBuffer().toString();

        try {OutputStream outputStream = Files.newOutputStream(path,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            outputStream.write(value.getBytes());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void read() throws IOException {
        Path path = Path.of("Contoh.csv");

        BufferedReader bufferedReader = Files.newBufferedReader(path);
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("Name", "From", "Role").build();

        CSVParser parser = new CSVParser(bufferedReader, format);
        for (CSVRecord record : parser) {
            System.out.println("Name : " + record.get("Name"));
            System.out.println("From : " + record.get("From"));
            System.out.println("Role : " + record.get("Role"));
        }
    }
}
