package hasanalmu.IO;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenOptions {

    @Test
    void openOptions() {
        Path path = Path.of("writer.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            for (int i = 0; i < 10; i++) {
                writer.write("halo \n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
