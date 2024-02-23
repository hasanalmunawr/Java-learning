package hasanalmunawr.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class TryMySelf2 {

    @Test
    void test() throws JsonProcessingException {
        Path path = Path.of("Try2.json");

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setDateFormat(new SimpleDateFormat("ss:mm:HH dd-mm-yyyy"));


        Account account = new Account();
        account.setName("kayla");
        account.setPassword("1334567");
        account.setCreateAt(new Date());
        account.setUpdateAt(new Date());

        String value = mapper.writeValueAsString(account);

        try (OutputStream outputStream = Files.newOutputStream(path,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND
                )) {
            outputStream.write(value.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void write() {
        Path path = Path.of("Try2.json");

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setDateFormat(new SimpleDateFormat("ss:mm:HH dd-mm-yyyy"));

        try (InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            byte[] bytes = new byte[1000];
            int length;

            while ((length = inputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, length));
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
