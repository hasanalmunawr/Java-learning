package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomersTest {

    @Test
    void testSetterGetter() {
        Customers customers = new Customers();
        customers.setId("Id");
        customers.setUsername("hasan");
        Assertions.assertEquals(customers.getId(), "Id");
        Assertions.assertEquals(customers.getUsername(), "hasan");
    }

    @Test
    void testConstractor() {
        Customers customers = new Customers();
        Customers customers1 = new Customers("Id","hasan");
        Assertions.assertEquals("Id", customers1.getId());
        Assertions.assertEquals("hasan", customers1.getUsername());
    }

    @Test
    void testEqualsHashCode() {
        Customers customers = new Customers("01", "hasan");
        Customers customers2 = new Customers("01", "almu");

        Assertions.assertEquals(customers, customers2);
        Assertions.assertEquals(customers.hashCode(), customers2.hashCode());

    }
}
