package hasanalmudev.belajarjavavalidation1;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class HibernateValidatorTest extends AbstractValidatorTest {

    @Test
    void testInvalid() {
        Payment payment = new Payment();
        payment.setOrderId("01");
        payment.setAmount(1000000L);
        payment.setCreditcard("12345678910");

        validate(payment);
    }

    @Test
    void testValid() {
        Payment payment = new Payment();
        payment.setOrderId("01");
        payment.setAmount(1000000L);
        payment.setCreditcard("4111111111111111"); // 16 digit

        validate(payment);
    }
}
