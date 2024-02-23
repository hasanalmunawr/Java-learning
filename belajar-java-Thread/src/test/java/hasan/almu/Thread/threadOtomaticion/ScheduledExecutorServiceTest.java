package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    @Test
    void delayedJobs() {
        var exce = Executors.newScheduledThreadPool(10);
         var future = exce.schedule(() -> System.out.println("hello world"), 5, TimeUnit.SECONDS);

        System.out.println(future.getDelay(TimeUnit.MILLISECONDS));

    }

    @Test
    void periodicJob() throws InterruptedException {
        var exce = Executors.newScheduledThreadPool(10);
        var future = exce.scheduleAtFixedRate(() -> System.out.println("bangun pagi"), 2, 3, TimeUnit.SECONDS);

        System.out.println(future.getDelay(TimeUnit.MILLISECONDS));

        exce.awaitTermination(10, TimeUnit.SECONDS);
    }
}
