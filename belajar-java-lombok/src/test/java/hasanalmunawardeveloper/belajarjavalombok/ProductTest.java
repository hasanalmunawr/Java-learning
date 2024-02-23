package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void testProduct() {
        Product product = Product.create("01");
        System.out.println(product);
    }
}
