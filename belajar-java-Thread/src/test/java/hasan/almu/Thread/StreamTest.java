package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    void create() {
        Stream<Integer> integerStream = IntStream.range(0, 1000).boxed();
        integerStream.parallel().forEach(value -> {
            System.out.println(Thread.currentThread().getName() + " : " + value);
        } );
    }

    @Test
    void costumForkJoinPool() {
        var pool = new ForkJoinPool(1);

        ForkJoinTask<?> task = pool.submit(() -> {
            Stream<Integer> integerStream = IntStream.range(0, 1000).boxed();
            integerStream.parallel().forEach(value -> {
                System.out.println(Thread.currentThread().getName() + " : " + value);
            });
        });

        task.join();
    }

}
