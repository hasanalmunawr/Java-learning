package hasan.almu.devResilience4J;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

@Slf4j
public class RetryConfigTest {

   String callHer() {
       log.info("Try call her");
       throw new RuntimeException("ups");
   }

    @Test
    void testRetryConfig() {
       RetryConfig retryConfig = RetryConfig.custom()
               .maxAttempts(5) // default 3
               .waitDuration(Duration.ofSeconds(3)) // default 0.5 secons
//               .ignoreExceptions() // kecuali throw illegal
               .retryExceptions(IllegalArgumentException.class) // khusus throw illegal
               .build();

       Retry retry = Retry.of("ha", retryConfig);
        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> callHer());
        supplier.get();
    }
}
