package hasanalmu.IO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {

    @Test
    void outputStream() {
        Path path = Path.of("example.txt");
        try (OutputStream stream = Files.newOutputStream(path)) {
            for (int i = 0; i < 30; i++) {
                int index = i;
                stream.write(("\n hello " + index).getBytes());
                stream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
