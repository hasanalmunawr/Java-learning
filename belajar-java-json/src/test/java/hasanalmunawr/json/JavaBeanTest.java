package hasanalmunawr.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaBeanTest {

    @Test
    void createJsonFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setFirstName("hasan");
        person.setLastName("almunawar");
        person.setAge(19);

        Addres addres = new Addres();
        addres.setStreet("jalan 2");
        addres.setProvince("jambi");
        addres.setCountry("indonesian");
        person.setAddres(addres);

        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(person);
        System.out.println(value);
    }

    @Test
    void readJsonToObject() throws JsonProcessingException {
        String json = """
                {
                  "firstName": "hasan",
                  "lastName": "almunawar",
                  "age": 19,
                  "addres": {
                    "street": "jalan 2",
                    "province": "jambi",
                    "country": "indonesian"
                  }
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, new TypeReference<Person>() {
        });

        Assertions.assertEquals("hasan", person.getFirstName());
        Assertions.assertEquals("almunawar", person.getLastName());
        Assertions.assertEquals(19, person.getAge());
    }

}
