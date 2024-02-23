package hasanalmunawr.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "hasan",
                "lastName", "almunawar",
                "age", 19,
                "married", false,
                "Addres", Map.of(
                        "Street", 2,
                        "provincie", "jambi",
                        "country", "indonesia"
                )
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(person);
        System.out.println(value);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "age": 19,
                  "married": false,
                  "lastName": "almunawar",
                  "firstName": "hasan",
                  "Addres": {
                    "country": "indonesia",
                    "Street": 2,
                    "provincie": "jambi"
                  }
                }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> readValue = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        System.out.println(readValue);

        Assertions.assertEquals("hasan", readValue.get("firstName"));
        Assertions.assertEquals("almunawar", readValue.get("lastName"));
    }
}
