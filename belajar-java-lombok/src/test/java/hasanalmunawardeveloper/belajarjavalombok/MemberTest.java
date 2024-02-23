package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MemberTest {

    @Test
    void testNonNull() {
        Assertions.assertThrows(NullPointerException.class , () -> {
            var member = new Member("hasan", "hasan");
            member.setId(null);
        });
    }

    @Test
    void testSayHello() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Member member = new Member("is", "hasn");
            member.sayHello(null);
        });
    }
}
