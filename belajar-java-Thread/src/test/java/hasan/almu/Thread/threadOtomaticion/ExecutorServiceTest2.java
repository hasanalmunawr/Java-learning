package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.*;

public class ExecutorServiceTest2 {

    @Test
    void singleExce() throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            for(int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("currently thread " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } );
        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void ecxeMulti() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
            for(int i = 0; i < 100; i++) {
                service.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("current thread : " + Thread.currentThread().getName());
                });

            }
        service.awaitTermination(1, TimeUnit.DAYS);
    }
}
