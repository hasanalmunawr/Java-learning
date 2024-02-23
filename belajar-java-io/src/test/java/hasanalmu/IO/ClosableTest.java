package hasanalmu.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClosableTest {

    @Test
    void closeIO() {
        Path path = Path.of("pom.xml");
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(path);
            // todo something
        } catch (IOException e) {
            Assertions.fail(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                Assertions.fail(e);
            }
        }
    }

    @Test
    void closeWithResource() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path);
             InputStream inputStream2 = Files.newInputStream(path);
             InputStream inputStream3 = Files.newInputStream(path);) {
            // todo something
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
