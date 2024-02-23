package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPollTest {

    @Test
    void createPoll() {
        var minThread = 10; //minimal thread yang akan dibuat
        var maxThread = 100; //maximal thread yang akan dibuat jika max
        var alive = 1; //berapa lama thread akan dihapus jika thread tidak bekerja
        var time = TimeUnit.MINUTES; //dalam bentuk menit

        var queue = new ArrayBlockingQueue<Runnable>(100); //maksimal antrian
        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, time, queue);
    }

    @Test
    void eksekusiRunable() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var time = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(100);
        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, time, queue);
        executor.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("current Thread is : "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(5000);
    }

    @Test
    void menghentikanthreadPoll() throws InterruptedException {
        var queqe = new ArrayBlockingQueue<Runnable>(1000);
        var executor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES, queqe);

        for(int i = 0; i < 1000; i++) {
            final var task = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task : " + task + " From thradPoll : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown(); // kalo mau dihentikan
//        executor.shutdownNow(); // menghasilkan intrup
        executor.awaitTermination(1, TimeUnit.DAYS); // menunggu sampe selesai dengn waktu 1 hari
    }

    private  static  class LogRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            System.out.println("Task : " + runnable + " is rejected");
        }
    }

    @Test
    void Rejected() throws InterruptedException {
//        membatasi object request membatasi penggunaan memori pada OS supaya apk memori tidak terpenuhi
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var timer = TimeUnit.MINUTES;

        var rejected = new LogRejectedExecutionHandler();
        var queque = new ArrayBlockingQueue<Runnable>(23);
        var execute = new ThreadPoolExecutor(minThread, maxThread, alive, timer, queque, rejected);

        for(int i = 0; i < 1000; i++) {
            final var task = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task : " + task + " From thradPoll : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            execute.execute(runnable);
        }
        execute.awaitTermination(1, TimeUnit.DAYS);
//        supaya tidak kelebihan beban
    }
}
