package hasan.almu.Thread.threadOtomaticion;

import hasan.almu.Thread.CounterLock;
import hasan.almu.Thread.CounterWriteReadLock;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    private CounterLock counterLock = new CounterLock();

    @Test
    void create() throws InterruptedException {

        Runnable runnable = () -> {
            for(int i = 0; i < 10000; i++) {
                counterLock.incrument();
            }
        };

        var thread = new Thread(runnable);
        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counterLock.getValue());
    }

    @Test
    void readWriteLock() throws InterruptedException {
        var readWrite = new CounterWriteReadLock();
        Runnable runnable = () -> {
            for(int i = 0; i < 1000; i++) {
                readWrite.increment();
            }
        };

        var thread = new Thread(runnable);
        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(readWrite.getValue());

    }

    private String message;
    @Test
    void condition() throws InterruptedException {
//        condition merupakan cara alternatif dari method (wait, notif, notiffAll)
        var lock = new ReentrantLock();
        var condition = lock.newCondition();

        var thread = new Thread(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(3000);
                message = "hasan almunawar";
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        thread.start();
        thread2.start();

        thread2.join();
        thread.join();
    }
}
