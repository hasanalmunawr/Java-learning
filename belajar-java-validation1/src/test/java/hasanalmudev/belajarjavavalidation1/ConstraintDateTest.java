package hasanalmudev.belajarjavavalidation1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ConstraintDateTest extends AbstractValidatorTest {

    @Test
    void test() {
        Person person = new Person();
        person.setFirstName("hasan");
        person.setLastName("almu");
        Address address = new Address();
        address.setCountry("indonesia");
        address.setCity("jambi");
        address.setStreet("jln 2");
        person.setAddress(address);
        person.setHobbies(new ArrayList<>());
        person.getHobbies().add(" ");
        person.getHobbies().add("  ");
        person.getHobbies().add("ngoding");
        person.getHobbies().add(" ");
        person.getHobbies().add("ngoding");

       validate(person);

    }
}
