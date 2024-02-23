package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

public class RaceConditionTest {

    @Test
    void Race() throws InterruptedException {
        var counter = new Counter();
        Runnable runnable = () -> {
            for(int i = 0; i < 1000; i++) {
                counter.incrument();
            }
        };

        var thread = new Thread(runnable);
        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);

        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread1.join();
        thread2.join();

        System.out.println(counter.getValue());
    }

    @Test
    void RaceSync() throws InterruptedException {
        var counter = new SynchronizedCounter();
        Runnable runnable = () -> {
            for(int i = 0; i < 1000; i++) {
                counter.incrument();
            }
        };

        var thread = new Thread(runnable);
        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);

        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread1.join();
        thread2.join();

    }

}
