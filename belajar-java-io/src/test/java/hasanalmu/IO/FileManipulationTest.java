package hasanalmu.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileManipulationTest {

    @Test
    void createPath() throws IOException {
        Path path = Path.of("contoh.txt");
        Files.createFile(path);
        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    void deletePath() throws IOException {
        Path path = Path.of("hasan.txt");
//        Files.delete(path);
        Files.deleteIfExists(path);
        Assertions.assertFalse(Files.exists(path));
    }

    @Test
    void copyPath() throws IOException {
        Path path1 = Path.of("contoh.txt");
        Path path2 = Path.of("example.txt");
        Files.copy(path1, path2);
        Assertions.assertTrue(Files.exists(path2));
    }

    @Test
    void movePath() throws IOException {
        Path path1 = Path.of("contoh.txt");
        Path path2 = Path.of("src/main/resources/", "example2.txt");
        Files.move(path1, path2, StandardCopyOption.REPLACE_EXISTING);
    }
}
