package hasan.devp.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFormatTest {

    private static final Logger log = LoggerFactory.getLogger(LogFormatTest.class);

    @Test
    void test() {
        log.info("hello word");
        log.info("{} + {} = {} ", 10, 10, (10+10));
        log.error("the error is ", new NullPointerException());
    }

    @Test
    void test1() {
        String firstName = "hasan";
        String lastName = "almunawar";
        String name = "deva";

        log.info("halo {} nama ku adalah {} dan aku berumur {}", (firstName +" "+ lastName), name, (190/10));
    }
}
