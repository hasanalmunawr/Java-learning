package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class TypeVariabelTest {

    @Test
    void getDateType() {
        Class<Data> dataClass = Data.class;

        TypeVariable<Class<Data>>[] typeParameters = dataClass.getTypeParameters();

        for(var i : typeParameters) {
            System.out.println(i.getName());
            System.out.println(Arrays.toString(i.getBounds()));
            System.out.println(i.getGenericDeclaration());

        }
    }
}
