package hasanalmudev.belajarjavavalidation1;

import org.junit.jupiter.api.Test;

public class ConstraintValidatorContextTest extends AbstractValidatorTest {

    @Test
    void test() {
        Register register = new Register();
        register.setUsername("hasan a");
        register.setPassword("l");
        register.setRetypePassword("badir");

        validate(register);
    }
}
