package hasan.almu.Thread.threadOtomaticion;

import hasan.almu.Thread.TImerTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPollTest2 {

    @Test
    void create() {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var timer = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(50);
        var execute = new ThreadPoolExecutor(minThread, maxThread, alive, timer, queue);

    }

    @Test
    void executeRunable() throws InterruptedException {
        var queue = new ArrayBlockingQueue<Runnable>(50);
        var execute = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES, queue);
        execute.execute(() -> {
            for(int i = 0; i < 1000; i++) {
                var taks = i;
                try {
                    Thread.sleep(1000);
                    System.out.println("Task : " + taks + " Thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread.sleep(10000);
    }

    @Test
    void menghentikanThreadPoll() throws InterruptedException {
        var queue = new ArrayBlockingQueue<Runnable>(1000);
        var execute = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES, queue);
         for (int i = 0 ;i < 1000; i++) {
             final var task = i;
             execute.execute(() -> {
                 try {
                     Thread.sleep(1000);
                     System.out.println("Task : " + task + " From thradPoll : " + Thread.currentThread().getName());
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             });
         }
         execute.awaitTermination(1, TimeUnit.MINUTES);
    }

    private  static  class LogRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            System.out.println("Task : " + runnable + " is rejected");
        }
    }

    @Test
    void rejected() throws InterruptedException {
        var queue = new ArrayBlockingQueue<Runnable>(50);
        var rejecte = new LogRejectedExecutionHandler();
        var execute = new ThreadPoolExecutor(5, 20, 1, TimeUnit.MINUTES, queue,rejecte);

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
        execute.awaitTermination(1, TimeUnit.MINUTES);
    }
}
