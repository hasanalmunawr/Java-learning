package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

    @Test
    void testArrayClass() {
        Class<String[]> aClass = String[].class;
        Class<int[]> aClass1 = int[].class;
        Class<Integer[][]> aClass2 = Integer[][].class;

        System.out.println(aClass.isArray());
        System.out.println(aClass1.isArray());
        System.out.println(aClass2.isArray());
        System.out.println(aClass1.getComponentType());
        System.out.println(aClass2.getComponentType());
        System.out.println(aClass.getComponentType());
    }

    @Test
    void testSetArray() {
        Class<String[]> aClass = String[].class;

        String[] array = (String[]) Array.newInstance(aClass.getComponentType(), 10);
        System.out.println(Arrays.toString(array));

        Array.set(array, 0, "didin");
        Array.set(array, 1, "dudun");
        System.out.println(Arrays.toString(array));

        System.out.println(Array.get(array,1));
        System.out.println(Array.get(array,0));
        System.out.println(Array.get(array,4));
    }

    @Test
    void testCreateArray() {
        Class<int[]> aClass = int[].class;
        Class<Integer[]> aClass1 = Integer[].class;

        System.out.println(aClass.isArray());
        System.out.println(aClass.getComponentType());
        System.out.println(aClass1.isArray());
        System.out.println(aClass1.getComponentType());

        int[] number = (int[]) Array.newInstance(aClass.getComponentType(), 10);

        System.out.println(Arrays.toString(number));
        Array.set(number, 0, 1);
        Array.set(number, 1, 2);
        System.out.println(Arrays.toString(number));

        System.out.println(Array.get(number, 1));
        System.out.println(Array.get(number, 9));
    }
}
