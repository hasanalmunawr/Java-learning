package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupConversionTest extends AbstractValidatorTest {

    @Test
    void testInvalid() {
        Payment payment = new Payment();
        payment.setOrderId("01");
        payment.setAmount(100000L);
        payment.setCreditcard("4111111111111111");
        payment.setVirtualAccount("llala ");
        payment.setCustomer(new Customer());

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
