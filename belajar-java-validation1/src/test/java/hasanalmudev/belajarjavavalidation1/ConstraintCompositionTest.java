package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class ConstraintCompositionTest extends AbstractValidatorTest {

    @Test
    void testCheckOrderId() {
        Locale.setDefault(new Locale("in", "ID"));
        Payment payment = new Payment();
        payment.setOrderId("");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
