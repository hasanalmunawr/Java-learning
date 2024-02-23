package hasanalmuDev.Belajarjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordTest {

    @Test
    void createRecord() {
        Class<Product> productClass = Product.class;

        System.out.println(productClass.isRecord());
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));
    }

    @Test
    void manualGetRecordValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Product> productClass = Product.class;
        Method id = productClass.getDeclaredMethod("id");
        Product product = new Product("B001", "keyborad", 12300L);
        System.out.println(id.invoke(product));
    }

    @Test // otomatis
    void recordCommponent() throws InvocationTargetException, IllegalAccessException {
        Product product = new Product("1", "Mouse", 120000L);
        Class<Product> productClass = Product.class;

        RecordComponent[] recordComponents = productClass.getRecordComponents();
        for(var record : recordComponents) {
            Method accessor = record.getAccessor();
            System.out.println(accessor.getName()); // nama field
            System.out.println(accessor.invoke(product)); // value field
        }
    }
}
