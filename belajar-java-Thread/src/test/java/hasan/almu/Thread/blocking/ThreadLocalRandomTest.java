package hasan.almu.Thread.blocking;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomTest {

//    membuat random tanpa terbatas


    @Test
    void create() throws InterruptedException {
        var service = Executors.newFixedThreadPool(10);

        service.execute(() -> {
            ThreadLocalRandom.current().ints(10,0, 1000)
                    .forEach(System.out::println);
        });

    }
}
