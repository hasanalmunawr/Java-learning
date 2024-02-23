package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

public class SuperClassTest {

    @Test
    void create() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<? super Person> objectClass = personClass.getSuperclass();
        System.out.println(objectClass);

        Class<? super Person> nullClass = objectClass.getSuperclass();
        System.out.println(nullClass);

    }

    @Test
    void name() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        Class<? super Person> superclass1 = superclass.getSuperclass();
        System.out.println(superclass1);
    }
}
