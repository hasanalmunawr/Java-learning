package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Test;

public class MerchantTest {

    @Test
    void testRequarimentConst() {
        Merchant merchant = new Merchant("Id");
        System.out.println(merchant.getId());

    }
}
