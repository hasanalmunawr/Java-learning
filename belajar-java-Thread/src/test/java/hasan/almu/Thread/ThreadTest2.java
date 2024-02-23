package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

public class ThreadTest2 {

    @Test
    void createThread() {
        var thread = new Thread(Thread.currentThread().getName());
        System.out.println(thread);
    }

    @Test
    void runableTest() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("nama Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        System.out.println("awal progam");
        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(4000);
        System.out.println(thread);
    }

    @Test
    void join() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("Progam sedang berjalan");
                for(int i = 0; i < 10; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        System.out.println("Awal progam");
        var thread = new Thread(runnable);
        thread.start();
        thread.join();
        System.out.println("akhir program");
    }

    @Test
    void interruptedTest() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("Progam sedang berjalan");
                for(int i = 1; i< 10;i++) {
                    System.out.println("index-"+i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                return;
            }
        };
        System.out.println("Program awal");
        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(10000); // time default nya 5, jika lewat 10 = break
        thread.interrupt();

        System.out.println("akhir progam");
        thread.join();
    }

    @Test
    void setGetNameThread() {
        Runnable runnable = ()-> {
            System.out.println(Thread.currentThread().getName());
        };

        var th = new Thread(runnable);
        th.setName("hasanThread");
        th.start();
        System.out.println(th.getName());
    }

    @Test
    void getState() throws InterruptedException {
        var thread = new Thread(()-> {
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(thread.getState());
        thread.start();
        thread.join();

        System.out.println(thread.getState());

    }
}
