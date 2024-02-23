package hasan.almu.devResilience4J;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class RateLimiterTest {

    private final AtomicLong counter = new AtomicLong(0L);

    @Test
    void testRateLimiter() {
        RateLimiter rateLimiter = RateLimiter.ofDefaults("ha");

        for (int i = 0; i < 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
                long incremented = counter.incrementAndGet();
                log.info("result {}", incremented);
            });
            runnable.run();
        }
    }

    @Test
    void testLimiterConfig() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100) // default 50
                .limitRefreshPeriod(Duration.ofMinutes(1)) // default 500(ns) dalam satu menit cuma boleh 100 request
                .timeoutDuration(Duration.ofSeconds(5)) // waktu menunggu rate limiter
                .build();

//        ini akan error karena dalam 1 menit hanya boleh 100 request

        RateLimiter rateLimiter = RateLimiter.of("ha", config);
        for (int i = 0; i < 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
                long incremented = counter.incrementAndGet();
                log.info("result {}", incremented);
            });
            runnable.run();
        }
    }

    @Test
    void testLimiterRegistry() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .timeoutDuration(Duration.ofSeconds(2))
                .build();

        RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.ofDefaults();
        rateLimiterRegistry.addConfiguration("config", config);

        RateLimiter rateLimiter = rateLimiterRegistry.rateLimiter("ha", "config");

        for (int i = 0; i < 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
                long incremented = counter.incrementAndGet();
                log.info("result {}", incremented);
            });
            runnable.run();
        }
    }
}
