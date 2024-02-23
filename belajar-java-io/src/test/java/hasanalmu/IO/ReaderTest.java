package hasanalmu.IO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {

    @Test
    void read() {
        Path path = Path.of("example.txt");
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder();
            int date;
            while((date = reader.read()) != -1) {
                builder.append((char) date);
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void readChars() {
        Path path = Path.of("example.txt");
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder();
            char[] chars = new char[1000];
            int length;
            int count = 0;
            while((length = reader.read(chars)) != -1) {
                builder.append(chars, 0, length);
                count++;
            }
            System.out.println(builder.toString());
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
