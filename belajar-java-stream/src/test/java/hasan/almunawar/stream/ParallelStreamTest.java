package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamTest {

    List<Integer> getNumbers() {
        return List.of(1,2,3,4,5,6,7,8,9,10);
    }

    @Test
    void testParallelStream() {
        Stream<Integer> parallelStr = getNumbers().stream().parallel();

        parallelStr.forEach(number -> {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        });
    }
}
