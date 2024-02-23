package hasan.almu.devResilience4J;

import io.github.resilience4j.retry.Retry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

@Slf4j
public class MetricTest {

    @SneakyThrows
    String slow() {
        log.info("slow bre");
        Thread.sleep(1000);
        throw new IllegalArgumentException("slow cok");
    }

    @Test
    void retryMetric() {
        Retry retry = Retry.ofDefaults("ha");

        try {
            Supplier<String> tSupplier = Retry.decorateSupplier(retry, () -> slow());
            tSupplier.get();
        } catch (Exception e) {
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithoutRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithoutRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithoutRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt());
        }

    }
}
