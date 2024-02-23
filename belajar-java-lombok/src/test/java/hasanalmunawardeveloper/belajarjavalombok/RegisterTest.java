package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterTest {

    @Test
    void test() {
        Register register = new Register("email", "password");
        Register register2 = new Register("hemail", "password");


    }

    @Test
    void testWith() {
        Register register = new Register("email", "hasan");
        var register2 = register.withEmail("hemail");

        Assertions.assertNotEquals(register.getEmail(), register2.getEmail());
    }
}
