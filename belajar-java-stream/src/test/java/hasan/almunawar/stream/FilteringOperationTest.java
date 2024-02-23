package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class FilteringOperationTest {

    @Test
    void testFilter() {
        List.of("hasan", "almunawar","software","engginer","java","spring boot")
                .stream()
                .filter(wolrd -> wolrd.length() >= 5)
                .map(upper -> upper.toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    void testFilterNumber() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        numbers.stream()
                .filter(genap -> genap % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    void testDistict() {
        List.of("hasan","eko","andi","eko","dudung","hasan")
                .stream()
                .distinct()
                .forEach(System.out::println);
    }
}
