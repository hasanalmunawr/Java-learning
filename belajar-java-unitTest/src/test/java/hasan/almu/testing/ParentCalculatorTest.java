package hasan.almu.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RandomParameterResolver.class)
public class ParentCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    public void  setUp() {
        System.out.println("before up");
    }
}
