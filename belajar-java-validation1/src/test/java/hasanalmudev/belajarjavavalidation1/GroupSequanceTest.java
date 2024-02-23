package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.group.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupSequanceTest extends AbstractValidatorTest {

    @Test
    void test() {
        Payment payment = new Payment();
        payment.setOrderId("01");
        payment.setAmount(1l);

        validateWithGroups(payment, PaymentGroup.class);
    }
}
