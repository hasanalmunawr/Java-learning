package contohPackage;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContohPackageTest {

    private static final Logger log = LoggerFactory.getLogger(ContohPackageTest.class);
    @Test
    void test() {
        log.trace("this is trace");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
    }
}
