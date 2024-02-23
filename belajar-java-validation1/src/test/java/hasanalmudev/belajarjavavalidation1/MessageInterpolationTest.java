package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.group.CreditCardPaymentGroup;
import hasanalmudev.belajarjavavalidation1.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {
        Payment payment = new Payment();
        payment.setOrderId("123488931230284291");
        payment.setAmount(1L);

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageI18N() {
        Payment payment = new Payment();
//        payment.setOrderId();
        payment.setAmount(1L);

        validateWithGroups(payment, CreditCardPaymentGroup.class);

    }

    @Test
    void testFull() {
        Payment payment = new Payment();

//        validateWithGroups(payment, CreditCardPaymentGroup.class);
        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
