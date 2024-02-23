package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClassTest {
    @Test
    void createTest() throws ClassNotFoundException {
        Class<Person> Class = Person.class;
        Class<?> class2 = Class.forName("hasanalmuDev.Belajarjavareflection.Person");
        
        Person person = new Person();
        Class<? extends  Person > classes = person.getClass();
    }

    @Test
    void classMethod() {
        Class<Person> personClass = Person.class;

        System.out.println(personClass.getSuperclass());
        System.out.println(Arrays.toString(personClass.getInterfaces()));
        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(personClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(personClass.getDeclaredFields()));
        System.out.println(personClass.getModifiers());
        System.out.println(personClass.getPackage());
        System.out.println(personClass.getName());
        System.out.println(personClass.getSimpleName());
    }
}
