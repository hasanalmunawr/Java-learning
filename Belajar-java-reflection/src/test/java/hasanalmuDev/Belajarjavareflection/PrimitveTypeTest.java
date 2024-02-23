package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrimitveTypeTest {

    @Test
    void name() {
        Class<Integer> integerClass = int.class;
        Class<String> stringClass = String.class;
        Class<Boolean> booleanClass = boolean.class;

        System.out.println(integerClass.isPrimitive());
        System.out.println(stringClass.isPrimitive());
        System.out.println(booleanClass.isPrimitive());

    }

    @Test
    void testPersonInt() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;

        Field age = personClass.getDeclaredField("age");
//        age.setAccessible(true);
        System.out.println(age.getType().isPrimitive());
    }

    @Test
    void getFieldFrmPrmtv() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        Field age = personClass.getDeclaredField("age");

        Person person = new Person();
        person.setAge(19);

        age.setAccessible(true);
        System.out.println(age.getInt(person));
    }

    @Test
    void getMethodPrmtv() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setAge = personClass.getDeclaredMethod("setAge", int.class);

        Person person = new Person();
        setAge.invoke(person, 20);

        System.out.println(person.getAge());
    }

    @Test
    void test() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass.isPrimitive());

        Class<Person> personClass = Person.class;

        // field set
        Field age = personClass.getDeclaredField("age");
        Person person = new Person();
        person.setAge(19);
        age.setAccessible(true);
        System.out.println(age.getInt(person));

        // method get
        Method getAge = personClass.getDeclaredMethod("setAge", int.class);
        Person person1 = new Person();
        getAge.invoke(person1, 20);
        System.out.println(person1.getAge());

    }
}
