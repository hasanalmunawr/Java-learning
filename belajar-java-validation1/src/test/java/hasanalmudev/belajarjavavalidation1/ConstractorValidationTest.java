package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstractorValidationTest extends AbstractValidatorTest{

    @Test
    void testValidateParameter() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Constructor<Person> constructor = personClass
                .getConstructor(String.class, String.class, Address.class);
        Set<ConstraintViolation<Person>> constraintViolations = executableValidator
                .validateConstructorParameters(constructor, new Object[]{firstName, lastName, address});
        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getLeafBean());
            System.out.println("==========");
        }
    }

    @Test
    void testValidateConstractorReturn() throws NoSuchMethodException {
        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Person person = new Person(firstName, lastName, address);

        Constructor<Person> constructor = Person.class
                .getConstructor(String.class, String.class, Address.class);
        Set<ConstraintViolation<Object>> constraintViolations = executableValidator
                .validateConstructorReturnValue(constructor, person);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getLeafBean());
            System.out.println("==========");
        }
    }
}
