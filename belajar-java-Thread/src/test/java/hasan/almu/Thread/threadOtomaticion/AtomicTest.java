package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest {

    private final AtomicLong value = new AtomicLong(0);

    private void incre() {
         value.incrementAndGet();
    }

    private long getVal() {
        return value.get();
    }

    @Test
    void counter() throws InterruptedException {
        AtomicTest value = new AtomicTest();
        Runnable runnable = () -> {
            for(int i = 0; i < 1000; i++) {
                    value.incre();
            }
        };

        var thread = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);
        var thread4 = new Thread(runnable);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(value.getVal());
    }
}
