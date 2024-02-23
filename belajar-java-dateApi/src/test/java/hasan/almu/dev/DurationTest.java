package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationTest {

    @Test
    void createDuration() {
        Duration duration = Duration.ofDays(10);
        Duration duration1 = Duration.ofHours(10);
        Duration duration2 = Duration.ofMinutes(10);
        Duration duration3 = Duration.ofSeconds(10);

        System.out.println(duration);
        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
    }

    @Test
    void Convert() {
        Duration duration = Duration.ofDays(1);

        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
    }

    @Test
    void during() {
        Duration duration1 = Duration.between(LocalTime.of(12, 33), LocalTime.of(15,43));
        Duration duration = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusMinutes(24));

        System.out.println(duration);
        System.out.println(duration.toMinutes());

        System.out.println(duration1);
        System.out.println(duration1.toMinutes());
    }
}
