package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

public class RaceConditionTest2 {

    @Test
    void create() throws InterruptedException {
        var counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
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
    void createSynchronized() throws InterruptedException {
        var counterSyn = new SynchronizedCounter();

        Runnable runnable = () -> {
            for(int i = 0; i < 12000; i++) {
                counterSyn.incrument();
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

        System.out.println(counterSyn.getValue());
    }
}
