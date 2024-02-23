package hasan.almu.testing;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

@Tag("Test-slow")
@Execution(ExecutionMode.CONCURRENT)
public class SlowTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void slow() throws InterruptedException {
        Thread.sleep(4_000);
    }
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
   void slow2() throws InterruptedException {
        Thread.sleep(4_000);
    }
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void slow3() throws InterruptedException {
        Thread.sleep(4_000);
    }

}
