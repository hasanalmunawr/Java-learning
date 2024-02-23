package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationsTest {

    @Test
    void create() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Assertions.assertNotNull(validator);

        validatorFactory.close();
    }
}
