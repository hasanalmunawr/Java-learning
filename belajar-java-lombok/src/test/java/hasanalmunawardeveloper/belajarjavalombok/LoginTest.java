package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    void testCreate() {
        Login login = Login.createEmpety();
        Login login2 = Login.create("hasan", "rahasia");

        Assertions.assertNull(login.getUsername());
        Assertions.assertNull(login.getPassword());

        Assertions.assertEquals("hasan", login2.getUsername());
        Assertions.assertEquals("rahasia", login2.getPassword());
    }

    @Test
    void testToString() {
        Login login = Login.create("hasan", "rahasia");
        System.out.println(login);


    }
}
