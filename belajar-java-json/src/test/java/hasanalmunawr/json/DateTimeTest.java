package hasanalmunawr.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {

    @Test
    void Date() throws JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("ss:mm:HH dd-MM-YYYY");

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setDateFormat(format);

        Person person = new Person();
        person.setFirstName("hasan");
        person.setAge(19);
        person.setCreateAt(new Date());
        person.setUpdateAt(new Date());

        String value = mapper.writeValueAsString(person);
        System.out.println(value);
    }
}
