package hasanalmunawardeveloper.belajarjavalombok;

import org.junit.jupiter.api.Test;

public class CounterTest {

    private Counter counter = new Counter();

    @Test
    void testWithoutSync() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                   counter.increment();
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(counter.getCounter());
    }
}
