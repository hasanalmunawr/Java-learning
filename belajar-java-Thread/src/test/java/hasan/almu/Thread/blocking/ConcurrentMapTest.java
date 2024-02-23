package hasan.almu.Thread.blocking;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentMapTest {
    @Test
    void create() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(100);
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
        var service = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 100; i++) {
            final var index = i;
            service.execute(() -> {
                try {
                    Thread.sleep(1000);
                    map.put(index, "data-"+index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    count.countDown();
                }
            });
        }

        service.execute(() -> {
            try {
                count.await();
                map.forEach((integer, s) -> System.out.println(integer + "receive : " + s));
                System.out.println("done all");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void conversi() {
        //dari java colllection ke thread
        List<String>list = List.of("hasan", "almu");
        Collections.synchronizedCollection(list);
    }
}
