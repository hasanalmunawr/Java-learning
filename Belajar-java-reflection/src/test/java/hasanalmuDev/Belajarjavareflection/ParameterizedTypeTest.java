package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParameterizedTypeTest {

    @Test
    void getMethodGeneric() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;

        Method getHobbies = personClass.getDeclaredMethod("getHobbies");

        Type returnType = getHobbies.getGenericReturnType();
        System.out.println(returnType.getClass());
        if(returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            System.out.println(parameterizedType.getRawType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));;
        }
    }

    @Test
    void getMethodParamter() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method getHobbies = personClass.getDeclaredMethod("setHobbies", List.class);

        Type[] genericParameterTypes = getHobbies.getGenericParameterTypes();
        for(var returnType : genericParameterTypes) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getTypeName());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    @Test
    void getGenericField() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field hobbies = personClass.getDeclaredField("hobbies");
        Type genericType = hobbies.getGenericType();

        if(genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            System.out.println(parameterizedType.getRawType());
            System.out.println(Arrays.toString(((ParameterizedType) genericType).getActualTypeArguments()));
        }
    }

    @Test
    void testByMap() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method getSize = personClass.getDeclaredMethod("getSize");

        Type[] genericExceptionTypes = getSize.getGenericExceptionTypes();
        for(var i : genericExceptionTypes) {
           ParameterizedType parameterizedType = (ParameterizedType) i;
            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getTypeName());
        }
    }
     @Test
    void testByMap2() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method getSize = personClass.getDeclaredMethod("setSize", HashMap.class);


    }

}
