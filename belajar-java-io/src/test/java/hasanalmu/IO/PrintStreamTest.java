package hasanalmu.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {

    @Test
    void name() {
        PrintStream stream = System.out;
        stream.println("halo ");
        stream.println("halo ");
        stream.println("halo ");
    }

    @Test
    void printstream() {
        Path path = Path.of("print.txt");

        try (OutputStream outputStream = Files.newOutputStream(path)) {
            PrintStream stream = new PrintStream(outputStream);
            stream.println("hello world");
            stream.println("hello world");
            stream.println("hello world");
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
