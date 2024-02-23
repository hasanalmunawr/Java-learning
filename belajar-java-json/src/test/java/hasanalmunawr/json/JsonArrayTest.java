package hasanalmunawr.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonArrayTest {

    @Test
    void createJsonArray() throws JsonProcessingException {
        List<String> hobbies = List.of("coding", "watching", "running");

        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(hobbies);
        System.out.println(value);
    }

    @Test
    void readArray() throws JsonProcessingException {
        String json = """
                ["coding","watching","running"]
                """;
        ObjectMapper mapper = new ObjectMapper();
        List<String> stringList = mapper.readValue(json, new TypeReference<List<String>>() {
        });
        System.out.println(stringList);
        Assertions.assertEquals("coding", stringList.get(0));
        Assertions.assertEquals("watching", stringList.get(1));
        Assertions.assertEquals("running", stringList.get(2));
    }
}
