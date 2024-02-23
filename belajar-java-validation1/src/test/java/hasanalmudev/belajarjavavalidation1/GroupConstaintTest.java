package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.group.CreditCardPaymentGroup;
import hasanalmudev.belajarjavavalidation1.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupConstaintTest extends  AbstractValidatorTest {

    @Test
    void testCreditCard() {
        Payment payment = new Payment();
        payment.setOrderId("01");
        payment.setAmount(1000000L);
        payment.setCreditcard("123");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
     @Test
    void testVirtualAccount() {
        Payment payment = new Payment();
        payment.setOrderId("01");
        payment.setAmount(1000000L);
        payment.setCreditcard("4111111111111111");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }

}
