package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class ConstractorTest {

    @Test
    void create() {
        Class<Person> personClass = Person.class;
        for(var contractor : personClass.getDeclaredConstructors()) {
            System.out.println(contractor.getName());
            for (var parameter : contractor.getParameters()) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());
            }
            System.out.println("============");
        }
    }

    @Test
    void createObject() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;

        Constructor<?>[] constructors = personClass.getConstructors();
        var personContractor = personClass.getConstructor(String.class, String.class);

        Person person3 = new Person("hasan");
//        Person person = constructors.
//        Person person1 = person.
        System.out.println(person3);
    }
}
