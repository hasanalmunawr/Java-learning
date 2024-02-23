package hasanalmudev.belajarjavavalidation1;

import org.junit.jupiter.api.Test;

public class CostumConstraintTest extends AbstractValidatorTest {

    @Test
    void testCustom() {
        Person person = new Person();
        person.setFirstName("hasan");
        person.setLastName("almunawar");
        person.setAddress(new Address());

        validate(person);
    }
}
