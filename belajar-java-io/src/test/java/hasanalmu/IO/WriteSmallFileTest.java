package hasanalmu.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteSmallFileTest {

    @Test
    void WriteSmallFiles() throws IOException {
        Path path = Path.of("src/main/resources/exampleDirectory", "helloWord.txt");
        byte[] bytes = "hello word by java".getBytes();
        Files.write(path, bytes);
        Assertions.assertTrue(Files.exists(path));

        Path path2 = Path.of("src/main/resources/exampleDirectory", "helloWord2.txt");
        Files.writeString(path2, "hello word by java");
        Assertions.assertTrue(Files.exists(path2));
    }
}
