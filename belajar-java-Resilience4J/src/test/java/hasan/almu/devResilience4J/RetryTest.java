package hasan.almu.devResilience4J;

import io.github.resilience4j.retry.Retry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

@Slf4j
public class RetryTest {


    void callMe() {
        log.info("Try call me");
        throw new IllegalArgumentException("Ups error");
    }

    @Test
    void testWihRetry() {
        Retry retry = Retry.ofDefaults("ha");
        retry.getEventPublisher().onEvent(event -> {
            log.info("Try to retry");
        });

        Runnable runnable = Retry.decorateRunnable(retry, () -> callMe());
                runnable.run();
    }

    String CallHer() {
        log.info("Try call her");
        throw new IllegalArgumentException("Filed call her:(");
    }

    @Test
    void testWithSupplier() {
        Retry retry = Retry.ofDefaults("ha");

        Supplier<String> stringSupplier = Retry.decorateSupplier(retry, () -> CallHer());
       stringSupplier.get();
    }
}
