package hasanalmunawardeveloper.belajarjavalombok;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@Slf4j
public class FileHelper {

    @SneakyThrows
    public static String fileLoad(String file)  {
        log.info("load file {}", file);
        @Cleanup FileReader fileReader = new FileReader(file);
        @Cleanup Scanner scanner = new Scanner(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        return stringBuilder.toString();
    }


}
