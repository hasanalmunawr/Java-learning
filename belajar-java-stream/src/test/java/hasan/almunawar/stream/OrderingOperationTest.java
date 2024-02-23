package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class OrderingOperationTest {

    @Test
    void testSorted() {
        List.of(1,2,7,2,6,9,5).stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testSortedWithComperator() {
        Comparator<Integer> comparator = Comparator.reverseOrder();

        List.of(12,65,34,89,22).stream()
                .sorted(comparator)
                .forEach(System.out::println);


    }
}
