package hasanalmu.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DIrectoryManipulationsTest {

    @Test
    void createDirectory() throws IOException {
        Path path = Path.of("src/main/resources/" ,"exampleDirectory");
        Files.createDirectory(path);
        Assertions.assertTrue(Files.exists(path));
        Assertions.assertTrue(Files.isDirectory(path));
    }

    @Test
    void deleteDirectory() throws IOException {
        Path path = Path.of("exampleDirectory");
//        Files.delete(path); // cara yang kurang tepat
        Files.deleteIfExists(path);
        Assertions.assertFalse(Files.exists(path));
    }


}
