package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.group.PaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadTest extends  AbstractValidatorTest {

    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(10000L);
        payment.setCreditcard("1234");

        Set<ConstraintViolation<Object>> validate = validator.validate(payment, PaymentGroup.class);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("============");

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> aClass : payload) {
                if(aClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

        }
    }
}
