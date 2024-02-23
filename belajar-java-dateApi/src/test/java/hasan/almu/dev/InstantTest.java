package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class InstantTest {

    @Test
    void createInstat() {
        Instant instant = Instant.now();
        Instant instant1 = Instant.ofEpochMilli(System.currentTimeMillis());

        System.out.println(instant);
        System.out.println(instant1);
    }

    @Test
    void modify() {
        Instant instant = Instant.now();

        Instant instant1 = instant.plusMillis(1000);
        Instant instant2 =  instant.minusMillis(300000);

        System.out.println(instant);
        System.out.println(instant1);
        System.out.println(instant2);
    }

    @Test
    void getInstance() {
        Instant instant = Instant.now();

        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
//        System.out.println(instant.ge());

    }

    @Test
    void conversiToInstant() {
        Instant instant = LocalDateTime.now().toInstant(ZoneOffset.ofHours(14));
        Instant instant1 = ZonedDateTime.now().toInstant();


        System.out.println(instant);
        System.out.println(instant1);
    }
}
