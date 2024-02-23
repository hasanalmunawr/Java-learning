package hasan.almu.Thread.synchronizer;

import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
//    => untuk memanage data counter

    @Test
    void create() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1); //jumlah yang dizinkan, membatasi pekerjaan yang dikerjaakan
        final ExecutorService executorService = Executors.newFixedThreadPool(100);

        for(int i = 0; i< 1000; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("Finish");
                } catch (InterruptedException e) {
                   e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
