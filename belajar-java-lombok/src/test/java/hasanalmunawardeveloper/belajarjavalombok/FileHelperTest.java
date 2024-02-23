package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class FileHelperTest {

    @Test
    void testLoadFile() throws Exception {
        String fileLoad = FileHelper.fileLoad("pom.xml");
        System.out.println(fileLoad);
    }

    @Test
    void testThrow() {
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            FileHelper.fileLoad("gaada.xixi");
        });
    }

    @Test
    void testLogger() {
        String fileLoad = FileHelper.fileLoad("pom.xml");
        System.out.println(fileLoad);
    }
}
