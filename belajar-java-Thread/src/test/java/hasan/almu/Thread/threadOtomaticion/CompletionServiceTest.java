package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {
    private Random random = new Random();


    @Test
    void create() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        CompletionService<String> comple = new ExecutorCompletionService<>(service);

        // submit task
        Executors.newSingleThreadExecutor().execute(() -> {
            for (int i = 0; i < 100; i++) {
                var index = i;
                comple.submit(() -> {
                    Thread.sleep(random.nextInt(2000));
                    return "task " + index;
                });
            }
        });

        // poll date
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                   Future<String> future = comple.poll(5, TimeUnit.SECONDS);
                    if(future == null) {
                        break;
                    } else {
                        System.out.println(future.get());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        service.awaitTermination(1, TimeUnit.MINUTES);
    }
}
