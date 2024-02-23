package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldTest {
    @Test
    void createTest() {
        Class<Person> personClass = Person.class;

        Field[] declaredFields = personClass.getDeclaredFields();

        for(var field : declaredFields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void getFieldObject() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true); // mengubah buat boleh diakses atau tidak

        Person person = new Person("hasan", "almunawar");
        String firstNameValue = (String) firstName.get(person);
        System.out.println(firstNameValue);

        Person person1 = new Person("ajiz", "nugraag");
        String result = (String) firstName.get(person1);
        System.out.println(result);
    }

    @Test
    void setFieldObject() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person = new Person("hasan", "satu");
        firstName.set(person, "bagus");
        String result = (String) firstName.get(person);
        System.out.println(result);

        Person person1 = new Person("bagus", "dua");
        firstName.set(person1, "ajux");
        String re    = (String) firstName.get(person1);
        System.out.println(re);
    }

    @Test
    void testGetField() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field declaredFields = personClass.getDeclaredField("firstName");
        declaredFields.setAccessible(true);

        Person person = new Person("satu");
        declaredFields.set(person, "hasan");
        String result = (String) declaredFields.get(person);
        System.out.println(result);

    }
}
