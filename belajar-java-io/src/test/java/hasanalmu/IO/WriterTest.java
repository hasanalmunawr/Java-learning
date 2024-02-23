package hasanalmu.IO;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {

    @Test
    void write() {
        Path path = Path.of("writer.txt");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write("hello world \n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
