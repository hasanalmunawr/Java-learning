package hasan.almu.Thread.synchronizer;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    @Test
    void test() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(4);
        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 5; i++) {
            service.execute(() -> {
                try {
                    System.out.println("Start task");
                    Thread.sleep(2000);
                    System.out.println("Finish Task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count.countDown(); //diturunkan satu persatu
                }
            });
        }

        service.execute(() -> {
            try {
                count.await(); // jika jumlah count tidak sama dengan task maka akan teru menunggu sampe 0
                System.out.println("All task finish");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        service.awaitTermination(1, TimeUnit.MINUTES);
    }
}
