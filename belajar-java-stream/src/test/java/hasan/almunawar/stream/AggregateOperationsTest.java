package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AggregateOperationsTest {
    @Test
    void testMax() {
        List<String> names = List.of("hasan","udin","dudung","edo","piko");
        names.stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

    }

    @Test
    void testMin() {
        List<String> names = List.of("hasan","udin","dudung","edo","piko");
        names.stream()
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }

    @Test
    void testCount() {
        long count = List.of("hasan","udin","dudung","edo","piko").stream().count();
        System.out.println(count); //menghitung jumlah data di dalam Stream

    }

    @Test
    void testSum() {
        var resultSum = List.of(1,2,3,4,5).stream()
                .reduce(0, (value,item) -> value + item);
        System.out.println(resultSum);
    }

    @Test
    void testFaktorial() {
        var resultFaktorial = List.of(1,2,3,4,5).stream()
                .reduce(1, (value, item) -> value * item);
        System.out.println(resultFaktorial);
    }
}
