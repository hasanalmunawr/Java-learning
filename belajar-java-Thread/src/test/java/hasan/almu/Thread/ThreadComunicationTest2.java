package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

public class ThreadComunicationTest2 {

    private String message = null;

    @Test
    void waitNotify() throws InterruptedException {
        Object object = new Object();
        var thread = new Thread(() -> {
            synchronized (object) {
                try {
                    object.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread1 = new Thread(() -> {
            synchronized (object) { // membuat mengantri
                object.notify();
                message = "selamat datang";
            }
        });

        thread.start();
        thread1.start();

        thread1.join();
        thread.join();

        System.out.println(message);

    }

    @Test
    void notifyAllTest() {
        String lock = new String();
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
        var thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                lock.notifyAll();
                message = "opo coyy";
            }
        });

        thread.start();
        thread2.start();
        thread3.start();



    }
}
