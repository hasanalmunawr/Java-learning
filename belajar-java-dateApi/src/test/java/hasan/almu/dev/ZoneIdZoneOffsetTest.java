package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

public class ZoneIdZoneOffsetTest {

    @Test
    void create() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneId zoneId1 = ZoneId.of("GMT");

        System.out.println(zoneId);
        System.out.println(zoneId1);

        Set<String> id = ZoneId.getAvailableZoneIds();
//        id.forEach(avaible -> System.out.println(avaible));

        ZoneOffset offset = ZoneOffset.of("+07:00");
        ZoneOffset offset1 = ZoneOffset.ofHours(7);
        ZoneOffset offset2 = ZoneOffset.ofHoursMinutes(5, 22);

        System.out.println(offset);
        System.out.println(offset1);
        System.out.println(offset2);
    }
}
