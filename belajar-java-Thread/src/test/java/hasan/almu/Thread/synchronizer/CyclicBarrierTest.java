package hasan.almu.Thread.synchronizer;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    @Test
    void create() {
        final CyclicBarrier cyc = new CyclicBarrier(5);
        final var service = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    System.out.println("waiting");
                    cyc.await(); // mengunngu disini sebanyak 5 cyc
                    System.out.println("Done waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
