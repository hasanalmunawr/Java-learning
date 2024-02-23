package hasan.almu.devResilience4J;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

@Slf4j
public class EventPublisherTest {

    @SneakyThrows
    String callHer() {
//        log.info("try to call herr");
        Thread.sleep(1000);
        throw new IllegalArgumentException("call her");
    }
    
    @Test
    void eventPublisher() {
        Retry retry = Retry.ofDefaults("ha");
        retry.getEventPublisher().onRetry(event -> log.info("try to retry"));

        try {
            Supplier<String> supplier = Retry.decorateSupplier(retry, () -> callHer());
            supplier.get();
        } catch (Exception e) {
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithRetryAttempt());
        }
    }

    @Test
    void retryPublisherRegistry() {
        RetryRegistry registry = RetryRegistry.ofDefaults();
        registry.getEventPublisher().onEntryAdded(event -> {
            log.info("add new entry {}", event.getAddedEntry().getName());
        });

        registry.retry("ha");
        registry.retry("ha");
        registry.retry("ha2");
    }
}
