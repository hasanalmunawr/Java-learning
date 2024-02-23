package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintDescriptorTest extends AbstractValidatorTest {

    @Test
    void test() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> validate = validator.validate(person);

        for (ConstraintViolation<Person> violation : validate) {
            ConstraintDescriptor<?> descriptor = violation.getConstraintDescriptor();
            System.out.println(descriptor.getAttributes());
            System.out.println(descriptor.getAnnotation());
            System.out.println(descriptor.getPayload());
            System.out.println(descriptor.getGroups());
            System.out.println("================");
        }
    }
}
