package hasanalmu.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadSmallFileTest {

    @Test
    void readFiles() throws IOException {
        Path path = Path.of("src/main/resources/exampleDirectory", "helloWord.txt");
        byte[] bytes = Files.readAllBytes(path);
        String string = new String(bytes);
        Assertions.assertEquals("hello word by java", string);
        System.out.println(string);
    }

    @Test
    void readFiles2() throws IOException {
        Path path = Path.of("src/main/resources/exampleDirectory", "helloWord2.txt");
        String readString = Files.readString(path);
        Assertions.assertEquals("hello word by java", readString);
        System.out.println(readString);
    }
}
