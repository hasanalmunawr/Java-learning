package hasanalmunawr.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JacksonAnnotationTest {

    @Test
    void create() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setDateFormat(new SimpleDateFormat("ss:mm:HH dd-MM-YYYY"));

        Account account = new Account();
        account.setName("hasan");
        account.setPassword("1234567");
        account.setCreateAt(new Date());
        account.setUpdateAt(new Date());

        String value = mapper.writeValueAsString(account);
        System.out.println(value);
    }
}
