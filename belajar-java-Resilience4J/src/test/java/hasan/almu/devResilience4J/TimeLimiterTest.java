package hasan.almu.devResilience4J;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class TimeLimiterTest {

    @SneakyThrows
    String slow() {
        log.info("slow");
        Thread.sleep(5000l);
        return "hasan";
    }

    @Test
    void testTImeLimiter() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> slow());

        TimeLimiter timeLimiter = TimeLimiter.ofDefaults("ha");
        Callable<String> stringCallable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);
        stringCallable.call();

    }

    @Test
    void testTimeLimiterConfig() throws Exception {
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(5)) // default 1, jika lebih dari 5 detik tidak akan dieksekusi
                .cancelRunningFuture(true) // cancel
                .build();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> slow());

        TimeLimiter timeLimiter = TimeLimiter.of("ha", config);
        Callable<String> stringCallable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);
        stringCallable.call();
    }

    @Test
    void testTimeLimiterRegisty() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> slow());

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(10)) // default 1, jika lebih dari 5 detik tidak akan dieksekusi
                .cancelRunningFuture(true) // cancel
                .build();

        TimeLimiterRegistry registry = TimeLimiterRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        TimeLimiter timeLimiter = registry.timeLimiter("ha", "config");
        Callable<String> stringCallable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);
        stringCallable.call();

    }
}
