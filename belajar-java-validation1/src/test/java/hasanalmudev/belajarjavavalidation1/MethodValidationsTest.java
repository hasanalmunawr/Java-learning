package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationsTest extends AbstractValidatorTest{

    @Test
    void testSayHello() throws NoSuchMethodException {
        Person person = new Person();
        String name = "";

        Method method = Person.class.getMethod("sayHello", String.class);
        Set<ConstraintViolation<Person>> constraintViolations = executableValidator
                .validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
            System.out.println("===============");

        }
    }

    @Test
    void testFullName() throws NoSuchMethodException {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");

        Method method = Person.class.getMethod("fullName");
        String returnValue = person.fullName();

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator
                .validateReturnValue(person, method, returnValue);

        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
            System.out.println("===============");

        }
    }
}
