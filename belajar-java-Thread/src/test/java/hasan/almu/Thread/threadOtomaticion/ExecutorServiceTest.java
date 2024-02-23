package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    @Test
    void createExecutorService() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i< 100; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Runable in thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void createExecutorServiceFix() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);  // mengeksekusi 10 kerjaan
        for(int i = 0; i< 100; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Runable in thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

}
