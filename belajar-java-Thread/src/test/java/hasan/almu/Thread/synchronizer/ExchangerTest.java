package hasan.almu.Thread.synchronizer;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {

    @Test
    void create() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        var exce = Executors.newFixedThreadPool(10);

        exce.execute(() -> {
            try {
                Thread.sleep(5000);
                var value = exchanger.exchange("Firts");
                System.out.println("1. " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        exce.execute(() -> {
            try {
                Thread.sleep(1000);
                var value = exchanger.exchange("seccond");
                System.out.println("2. " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        exce.awaitTermination(1, TimeUnit.MINUTES);
    }
}
