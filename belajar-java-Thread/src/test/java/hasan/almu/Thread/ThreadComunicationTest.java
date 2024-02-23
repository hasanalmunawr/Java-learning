package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

public class ThreadComunicationTest {

    private String message = null;

    @Test
    void test() throws InterruptedException {
        var thread = new Thread(() -> {
            while(message == null) {

            }
            System.out.println(message);
        });
        var thread1 = new Thread(() -> {
           message = "hasan";
        });

//        thread1.start();
        thread.start();
        thread1.join();
        thread.join();

    }

    @Test
    void waitmodify() throws InterruptedException {
        final Object lock = new Object();
        var thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(lock);
            }
        });

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                lock.notify();
                message = "depa";
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(message);
    }

    @Test
    void notifyAllTest() throws InterruptedException {
        final Object lock = new Object();
        var thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
            var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "depa";
                lock.notifyAll();
            }
        });

        thread.start();
        thread1.start();
        thread2.start();

        thread2.join();
        thread.join();
        thread1.join();


    }
}
