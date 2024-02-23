package hasan.almu.testing;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class LifecycleTest {

    @Test
    @Order(1)
    public void TestEmpat() {

    }
    @Test
    @Order(2)
    public void TestTiga() {

    }
    @Test
    @Order(3)
    public void TestDua() {

    }
    @Test
    @Order(4)
    public void TestSatu() {

    }
}
