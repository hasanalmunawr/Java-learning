package hasan.almu.devResilience4J;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@Slf4j
public class RetryRegisterTest {

    void callHer() {
        log.info("Try call her");
        throw new IllegalArgumentException("failed");
    }
    @Test
    void testRetryRegister() {
        RetryRegistry registry = RetryRegistry.ofDefaults();

        Retry retry = registry.retry("ha");
        Retry retry2 = registry.retry("ha");

        Assertions.assertSame(retry, retry2);

        retry.executeRunnable(() -> callHer());
    }

    @Test
    void testCreateConfig() {
        RetryConfig registry = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .build();

        RetryRegistry retryRegistry = RetryRegistry.of(registry);
        retryRegistry.addConfiguration("config", registry);

        Retry retry = retryRegistry.retry("ha", "config");

//        retry.executeRunnable(() -> callHer());
        Retry.decorateRunnable(retry, () -> callHer()).run();

    }
}
