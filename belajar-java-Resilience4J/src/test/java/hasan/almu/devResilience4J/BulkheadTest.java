package hasan.almu.devResilience4J;

import io.github.resilience4j.bulkhead.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Slf4j
public class BulkheadTest {

    private final AtomicLong counter = new AtomicLong(0L);

    @SneakyThrows
    void slow() {
        long incremented = counter.incrementAndGet();
        log.info("counter {}", incremented);
        Thread.sleep(2000l);
    }

    @Test
    void testSemaphore() throws InterruptedException {
        Bulkhead bulkhead = Bulkhead.ofDefaults("ha");

        for (int i = 0; i < 1000; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> slow());
            new Thread(runnable).start();
        }
        Thread.sleep(10000);
    }

    @Test
    void testTHreadPoll() {
        log.info(String.valueOf(Runtime.getRuntime().availableProcessors()));
        ThreadPoolBulkhead threadPoolBulkhead = ThreadPoolBulkhead.ofDefaults("ha");
        for (int i = 0; i < 1000; i++) {
            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(threadPoolBulkhead, () -> slow());
            supplier.get();

        }
    }

    @Test
    void testBulkheadConfig() throws InterruptedException {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5) // max yang dipanggil
                .maxWaitDuration(Duration.ofSeconds(2)) // waktu tuunggu antri
                .build();

        Bulkhead bulkhead = Bulkhead.of("ha", config);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> slow());
            new Thread(runnable).start();
        }
        Thread.sleep(10000);
    }

    @Test
    void testFIxThreadBulkhead() throws InterruptedException {
        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(5)
                .coreThreadPoolSize(5)
                .queueCapacity(3) // antrian, minimal 1 default nya 100
                .build();

        ThreadPoolBulkhead bulkhead = ThreadPoolBulkhead.of("ha", config);
        for (int i = 0; i <20 ; i++) {
            ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> slow()).get();
        }

        Thread.sleep(20000);
    }

    @Test
    void testBulkHeadRegistry() throws InterruptedException {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofSeconds(4))
                .build();

        BulkheadRegistry bulkheadRegistry = BulkheadRegistry.ofDefaults();
        bulkheadRegistry.addConfiguration("config", config);

        Bulkhead bulkhead = bulkheadRegistry.bulkhead("ha", "config");
        for (int i = 0; i < 10; i++) {
            Bulkhead.decorateRunnable(bulkhead, () -> slow()).run();
        }
        Thread.sleep(10000);
    }

    @Test
    void testTHreadPoolRegisty() throws InterruptedException {
        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(5)
                .coreThreadPoolSize(5)
//                .queueCapacity(3) // antrian, minimal 1 default nya 100
                .build();

        ThreadPoolBulkheadRegistry registry = ThreadPoolBulkheadRegistry.ofDefaults();
        registry.addConfiguration("config", config);
        ThreadPoolBulkhead bulkhead = registry.bulkhead("ha", "config");
        for (int i = 0; i <20 ; i++) {
            ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> slow()).get();
        }

        Thread.sleep(20000);
    }
}
