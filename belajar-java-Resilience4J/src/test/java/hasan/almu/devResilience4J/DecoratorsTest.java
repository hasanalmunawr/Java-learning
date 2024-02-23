package hasan.almu.devResilience4J;

import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class DecoratorsTest {

    private final AtomicLong counter = new AtomicLong();

    @SneakyThrows
    void slow() {
        log.info("slow : {}", counter.incrementAndGet());
        Thread.sleep(1_000L);
        throw new IllegalArgumentException("ups");
    }

    @Test
    void decorators() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.of("ha-rateLimiter", RateLimiterConfig.custom()
                        .limitForPeriod(5)
                        .limitRefreshPeriod(Duration.ofMinutes(1))
                        .build());

        Retry retry = Retry.of("ha-retry", RetryConfig.custom()
                        .maxAttempts(10)
                        .waitDuration(Duration.ofMillis(10))
                        .build());

        Runnable runnable = Decorators.ofRunnable(() -> slow())
                .withRetry(retry)
                .withRateLimiter(rateLimiter)
                .decorate();

        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);
    }
}
