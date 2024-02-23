package hasanalmunawr.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TryMySelf {

    @Test
    void testCreateJson() throws JsonProcessingException {
        Person person = new Person();
        person.setFirstName("kayla");
        person.setLastName("deva");
        person.setAge(18);

        Addres addres = new Addres();
        addres.setStreet("jalan kosong");
        addres.setProvince("sby");
        addres.setCountry("indonesian");
        person.setAddres(addres);

        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(person);

        Path path = Path.of("test.json");
        try (OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            outputStream.write(value.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testReadJson() {
        Path path = Path.of("test.json");
        try (InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            byte[] bytes = new byte[1000];
            int read;
            int counter =0 ;
            while((read = inputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, read));
                counter++;
            }
            System.out.println(builder.toString());
            System.out.println(counter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
