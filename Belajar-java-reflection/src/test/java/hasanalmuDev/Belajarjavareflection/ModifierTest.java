package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class ModifierTest {
    @Test
    void create() {
        Class<Person> personClass = Person.class;
        int modifiers = personClass.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.isPublic(personClass.getModifiers()));
        System.out.println(Modifier.isFinal(personClass.getModifiers()));
        System.out.println(Modifier.isStatic(personClass.getModifiers()));

    }

    @Test
    void name() {
       Class<NameAble> nameAbleClass = NameAble.class;

        System.out.println(Modifier.isPublic(nameAbleClass.getModifiers()));
        System.out.println(Modifier.isInterface(nameAbleClass.getModifiers()));
    }
}
