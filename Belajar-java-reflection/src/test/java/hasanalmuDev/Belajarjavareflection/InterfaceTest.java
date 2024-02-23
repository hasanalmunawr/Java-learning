package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InterfaceTest {

    @Test
    void create() {
        Class<Person> personClass = Person.class;
        Class<NameAble> nameAbleClass = NameAble.class;

        System.out.println(nameAbleClass.getName());
        System.out.println(nameAbleClass.getSuperclass());
        System.out.println(nameAbleClass.isInterface());
        System.out.println(Arrays.toString(nameAbleClass.getInterfaces()));
        System.out.println(Arrays.toString(nameAbleClass.getDeclaredFields()));
        System.out.println(Arrays.toString(nameAbleClass.getDeclaredMethods()));

    }

    @Test
    void superInterface() {
        Class<Person> personClass = Person.class;
        System.out.println(Arrays.toString(personClass.getInterfaces()));
    }

    @Test
    void name() {
        Class<NameAble> nameAbleClass = NameAble.class;

        System.out.println(Arrays.toString(nameAbleClass.getDeclaredMethods()));
    }
}
