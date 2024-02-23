package hasanalmu.IO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerTest {

    @Test
    void scanner() {
        Path path = Path.of("print.txt");

        try (InputStream inputStream = Files.newInputStream(path)) {
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                System.out.println(nextLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
