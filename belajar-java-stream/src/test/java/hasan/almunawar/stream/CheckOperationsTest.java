package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationsTest {

    @Test
    void testAnyMatch() {
        var resultAny = List.of("hasan","udin","dudung","edo","piko").stream()
                .anyMatch(nama -> nama.length() >= 6);
        System.out.println(resultAny);
    }

    @Test
    void testAllMatch() {
        var resultAll = List.of("hasan","udin","dudung","edo","piko").stream()
                .allMatch(nama -> nama.length() > 0);
        System.out.println(resultAll);
    }

    @Test
    void testNoneMatch() {
        var resultNone = List.of("hasan","udin","dudung","edo","piko").stream()
                .noneMatch(nama -> nama.length() < 5);
        System.out.println(resultNone);
    }
}
