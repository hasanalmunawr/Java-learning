package hasan.almu.Thread;

import org.junit.jupiter.api.Test;


public class ThreadTest {

    @Test
    void mainThread() {
        String thread = Thread.currentThread().getName();

        System.out.println(thread);
    }

    @Test
    void runableTest() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1_000);
                System.out.println("Name Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(3_000);

        System.out.println("Program finish");

//        Thread.sleep(3_000);
    }
//    370 445


    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Name Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("menunggu join");
        thread.join();
        System.out.println("akhir dari program");

    }

    @Test
    void threadInterrptUncorrect() throws InterruptedException {
        Runnable runnable = () -> {
               for(int i = 0; i < 10; i++) {
                   System.out.println("ini ke-"+i);
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
//                       return;
                       e.printStackTrace();
                   }
               }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("akhir dari program");
        thread.join();

    }
    @Test
    void threadInterrptCorrect() throws InterruptedException {
        Runnable runnable = () -> {
               for(int i = 0; i < 10; i++) {
                   System.out.println("ini ke-"+i);
                   // MANUAL CHECK INTERRUPTED
                   if(Thread.interrupted()) {
                       break;
                   }
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       return;
                   }
               }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("menuggu selesai");
        Thread.sleep(5000); //kunci
        thread.interrupt();
        thread.join();
        System.out.println("akhir progam");

    }

    @Test
    void setNameThread() {
        var thread = new Thread(() -> {
            System.out.println("Thread Name : " + Thread.currentThread().getName());
        });
        thread.setName("Hasan");
        thread.start();
    }

    @Test
    void getstateTread() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("nama thread : " +Thread.currentThread().getName());
        });
        System.out.println(thread.getState()); // New
        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }
}
