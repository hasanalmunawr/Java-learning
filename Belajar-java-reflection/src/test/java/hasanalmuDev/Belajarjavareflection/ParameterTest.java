package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {

    @Test
    void createTest() {
        Class<Person> personClass = Person.class;

        for(var method : personClass.getDeclaredMethods()) {
            Parameter[] parameters = method.getParameters();
            System.out.println(method.getName());
            for(var parameter : parameters) {
                System.out.println("Name : " + parameter.getName());
                System.out.println("Typre : " + parameter.getType());
            }
            System.out.println("========== ");
        }
    }

    @Test
    void methodInvokeParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("budi", "nugraha");
        setFirstName.invoke(person, "agus");
        System.out.println(person.getFirstName());

        Person person1 = new Person("dua", "almunaw");
        setFirstName.invoke(person1, "asan");
        System.out.println(person1.getFirstName());
    }

    @Test
    void setParamterTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method longer = personClass.getDeclaredMethod("longer", String.class, int.class);

        Person person = new Person("dnn");
        Object akuAdalahAnakSehar = longer.invoke(person, "aku adalah anak sehar", 4);
        System.out.println(person.getAge());

        Person person2 = new Person("dnn");
        Object akuAdalahAnakSehar2 = longer.invoke(person2, "hasan almunawar", 4);
        System.out.println(person2.getAge());

    }
}
