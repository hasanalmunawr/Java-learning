package hasanalmuDev.Belajarjavareflection;

import hasanalmuDev.Belajarjavareflection.validation.Validator;
import org.junit.jupiter.api.Test;

public class AnnotationTest {

    @Test
    void testNotBlank() throws RuntimeException, IllegalAccessException {
        Person person = new Person("hasan", "almunawar");
        Validator.validationNoBlank2(person);
    }

}
