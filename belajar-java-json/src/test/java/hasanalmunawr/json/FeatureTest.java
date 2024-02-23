package hasanalmunawr.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FeatureTest {

    @Test
    void mapperFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                {
                  "FirstName": "hasan",
                  "lastName": "almunawar",
                  "Age": 19,
                  "addres": {
                    "street": "jalan 2",
                    "province": "jambi",
                    "country": "indonesian"
                  }
                }
                """;
        Person person = mapper.readValue(json, Person.class);
        Assertions.assertEquals("hasan", person.getFirstName());
        Assertions.assertEquals("almunawar", person.getLastName());
        Assertions.assertEquals(19, person.getAge());
    }

    @Test
    void deserilationFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true) // tidak harus list bisa singgle array
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // gagalkan jika properti tidak diketahui

        String json = """
                {"firstName":"hasan", "age":19, "hobbies":"Coding", "kam": 13}
                """;

        Person person = mapper.readValue(json, Person.class);
        Assertions.assertEquals("hasan", person.getFirstName());
        Assertions.assertEquals(19, person.getAge());
//        Assertions.assertEquals("Coding", person.getHobbies());
    }

    @Test
    void serializationFeature() throws JsonProcessingException {
            Person person = new Person();
            person.setFirstName("has");
            person.setLastName("de");
            person.setAge(1421);

            Addres addres = new Addres();
            addres.setStreet("jalan kosong");
            addres.setProvince("jogja");
            addres.setCountry("indonesian");
            person.setAddres(addres);

            ObjectMapper mapper = new ObjectMapper()
                    .configure(SerializationFeature.INDENT_OUTPUT, true); // membuat terususn , namu cukup memakan memori
            String value = mapper.writeValueAsString(person);
        System.out.println(value);

//            Path path = Path.of("test.json");
//            try (OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE,
//                    StandardOpenOption.APPEND)) {
//                outputStream.write(value.getBytes());
//                outputStream.flush();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
    }

    @Test
    void serialzationInclusion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setFirstName("hasan");
        person.setAge(19);

        String value = mapper.writeValueAsString(person);
        System.out.println(value);
    }
}
