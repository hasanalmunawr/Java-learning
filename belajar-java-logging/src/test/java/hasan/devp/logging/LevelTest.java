package hasan.devp.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelTest {
    private static final Logger log = LoggerFactory.getLogger(LevelTest.class);

    @Test
    void test() {
        log.trace("this trace level");
        log.debug("this debug level");
        log.info("this info level");
        log.warn("this warning level");
        log.error("this error level");
    }
}
