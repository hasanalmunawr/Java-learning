package hasan.almu.testing;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;
@Tag("Condition-Test")
public class ConditionTest {

//    CONDITION ON OS
    @Test
    @EnabledOnOs({OS.WINDOWS}) //hanya bisa di jalankan di windows
    public void enableTestOS() {
        System.out.println("ini windows");
    }

    @Test
    @DisabledOnOs({OS.WINDOWS}) //tidak bisa di jalankan di windows
    public void disableTestOS() {
        System.out.println("ini windows");
    }

//    CONDITION AT JAVA VERSION
    @Test
    @EnabledOnJre({JRE.JAVA_20})
    public void enableJavaVersion() {

    }
    @Test
    @DisabledOnJre({JRE.JAVA_20})
    public void disableJavaVersion() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_15, max = JRE.JAVA_20)
    public void enableJavaVersionTo() {

    }
    @Test
    @DisabledForJreRange(min = JRE.JAVA_15, max = JRE.JAVA_20)
    public void disableJavaVersionTo() {

    }

//    CONDITION IN SYSTEM PROPERTY
//    @Test
//    public void testProperties() {
//        Properties proper = System.getProperties();
//        proper.forEach((key, value) -> System.out.println(key + ":" + value));
//    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void enablesystemProperty() {

    }
    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void disablesystemProperty() {

    }

//    CONDITION ENVRIMENT VALIABELS
    @Test
    @EnabledIfEnvironmentVariable(named = "HASAN", matches = "DEPOL")
    public void testEnvironmentEnable() {

    }
    @Test
    @DisabledIfEnvironmentVariable(named = "HASAN", matches = "DEPOLL")
    public void testEnvironmentDisable() {

    }

}
