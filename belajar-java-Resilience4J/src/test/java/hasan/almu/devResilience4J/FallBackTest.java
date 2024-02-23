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
import java.util.function.Supplier;

@Slf4j
public class FallBackTest {

    private final AtomicLong counter = new AtomicLong(0);
    @SneakyThrows
    String sayHello(){
        log.info("say hello {}", counter.incrementAndGet());
        Thread.sleep(1000);
      throw new IllegalArgumentException("ups");
    }

    @Test
    void fallBack() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.of("ha-rateLimiter", RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .build());

        Retry retry = Retry.of("ha-retry", RetryConfig.custom()
                .maxAttempts(10)
                .waitDuration(Duration.ofMillis(10))
                .build());

        Supplier<String> decorate = Decorators.ofSupplier(() -> sayHello())
                .withRetry(retry)
                .withRateLimiter(rateLimiter)
                .withFallback(throwable -> "hello fallBack")
                .decorate();

        System.out.println(decorate.get());

        Thread.sleep(10000);

    }
}
