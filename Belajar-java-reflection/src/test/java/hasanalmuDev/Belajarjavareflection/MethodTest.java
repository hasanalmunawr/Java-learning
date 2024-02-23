package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    void createTest() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();

        for(var method : declaredMethods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getTypeParameters()));
            System.out.println(Arrays.toString(method.getExceptionTypes()));
            System.out.println("==========");
        }
    }

    @Test
    void getMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method methods = personClass.getDeclaredMethod("getLastName");

        Person person = new Person("satu", "hasan");
        String result = (String) methods.invoke(person);
        System.out.println(result);

        Person person1 = new Person("dua", "almunawar");
        String result1 = (String) methods.invoke(person1);
        System.out.println(result1);

    }

    @Test
    void testGetMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method getLong = personClass.getDeclaredMethod("getLong");

        Person person = new Person("hasan", "almunawar");
        int invoke = (int) getLong.invoke(person);
        System.out.println(invoke);

        Person person2 = new Person("husinn", "got");
        int invoke2 = (int) getLong.invoke(person2);
        System.out.println(invoke2);

    }
}
