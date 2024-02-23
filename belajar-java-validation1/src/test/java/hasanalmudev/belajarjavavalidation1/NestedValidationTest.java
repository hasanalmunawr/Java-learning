package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest  {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void test() {
       Person person = new Person();
       person.setFirstName("hasan");
       person.setLastName("almunawar");

       Address address = new Address();
       address.setStreet("jalan 2");
       address.setCity("jambi");
       address.setCountry("indonesia");
       person.setAddress(address);

        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        for (ConstraintViolation<Person> personConstraintViolation : validate) {
            System.out.println(personConstraintViolation.getPropertyPath());
            System.out.println(personConstraintViolation.getMessage());
            System.out.println("++++++++");
        }
    }
}
