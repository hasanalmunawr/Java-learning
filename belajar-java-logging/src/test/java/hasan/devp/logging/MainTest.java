package hasan.devp.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {
    private static final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    void test() {
        log.info("hello java");
        System.out.println("hello java");
        log.info("ini adalah java logging");
        System.out.println("ini adalah java logging");
    }

    @Test
    void testMainMain() throws InterruptedException {
        var index = 0 ;
        for(int i = 0; i < 10; i++) {
            index = i;
            log.info("ini login ke " + index);
            Thread.sleep(1000);
        }

    }
}
