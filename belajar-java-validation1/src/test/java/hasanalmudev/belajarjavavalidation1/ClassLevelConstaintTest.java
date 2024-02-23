package hasanalmudev.belajarjavavalidation1;

import org.junit.jupiter.api.Test;

public class ClassLevelConstaintTest extends AbstractValidatorTest {

    @Test
    void testRegister() {
        Register register = new Register();
        register.setUsername("hasan");
        register.setPassword("badiro");
        register.setRetypePassword("badiro123142");

        validate(register);
    }
}
