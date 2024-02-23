package hasan.almunawar.stream;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamClassTest {

    @Test
    void testCreate() {
        IntStream intStream = IntStream.range(1,10);
        intStream.forEach(System.out::println);

        LongStream longStream = LongStream.of(1,2,3,4,5);
        longStream.forEach(System.out::println);

        DoubleStream doubleStream = DoubleStream.builder().add(0.1).add(9.9).build();
        doubleStream.forEach(System.out::println);
    }

    @Test
    void testPrimitiveOperationStream() {
        OptionalDouble optionalDouble = IntStream.range(1,20).average();
        System.out.println(optionalDouble);

        Stream<String> stringStream = IntStream.range(1,5)
                .mapToObj(number -> String.valueOf(number));
        stringStream.forEach(System.out::println);
    }
}
