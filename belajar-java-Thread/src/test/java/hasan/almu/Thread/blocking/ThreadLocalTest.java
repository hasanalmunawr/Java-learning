package hasan.almu.Thread.blocking;

import hasan.almu.Thread.UserService;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    private UserService userService = new UserService();
    private Random random = new Random();

    @Test
    void create() throws InterruptedException {
        // value menepel pada thread,
        var executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 100; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    userService.setUser("data-"+index);
                    Thread.sleep(1000+ random.nextInt(3000));
                    userService.doAction();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.MINUTES);

    }
}
