package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstainsValidatorTest {

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
    void validationTest() {
        Person person = new Person();
        person.setFirstName("hasanhasanhasanhahsanhasanhasan");
        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        Assertions.assertEquals(3,validate.size());

        for (ConstraintViolation<Person> personConstraintViolation : validate) {
            System.out.println(personConstraintViolation);
            System.out.println(personConstraintViolation.getMessage());
            System.out.println(personConstraintViolation.getLeafBean());
            System.out.println(personConstraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println(personConstraintViolation.getInvalidValue());
            personConstraintViolation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("===========");
        }
    }
}
