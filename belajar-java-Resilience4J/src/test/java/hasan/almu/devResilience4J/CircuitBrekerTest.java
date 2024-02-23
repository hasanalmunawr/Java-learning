package hasan.almu.devResilience4J;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class CircuitBrekerTest {

    private final AtomicLong counter = new AtomicLong(0L);

    void callMe() {
        log.info("call Me");
        throw new IllegalArgumentException("ups");
    }

    @Test
    void circuitBreker() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("ha");

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Exception e) {
                log.info("error : {} {}", counter.incrementAndGet(),e.getMessage());
            }
        }
    }

    @Test
    void circuitBrekerConfig() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED) //cara menghitungnya, TIME/COunt defaultnya adalah couunt
                .failureRateThreshold(10f) // default nya 50%
                .slidingWindowSize(10) // akhir yang di eksekusi , 100
                .minimumNumberOfCalls(10) // jumlah minimal dieksekusi sebelum error , default nya 100
                .waitDurationInOpenState(Duration.ofSeconds(60)) // waktu menunggu menjadi half open
                .permittedNumberOfCallsInHalfOpenState(10) // di coba 10
                .build();

        CircuitBreaker circuitBreaker = CircuitBreaker.of("ha", config);

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Exception e) {
                log.info("error : {} {}", counter.incrementAndGet(),e.getMessage());
            }

        }
    }

     @Test
    void circuitBrekerRegisty() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED) //cara menghitungnya, TIME/COunt defaultnya adalah couunt
                .failureRateThreshold(10f) // default nya 50%
                .slidingWindowSize(10) // akhir yang di eksekusi , 100
                .minimumNumberOfCalls(10) // jumlah minimal dieksekusi sebelum error , default nya 100
                .waitDurationInOpenState(Duration.ofSeconds(60)) // waktu menunggu menjadi half open
                .permittedNumberOfCallsInHalfOpenState(10) // di coba 10
                .build();

         CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
         registry.addConfiguration("config", config);

        CircuitBreaker circuitBreaker = registry.circuitBreaker("ha", "config");

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Exception e) {
                log.info("error : {} {}", counter.incrementAndGet(),e.getMessage());
            }

        }
    }


}
