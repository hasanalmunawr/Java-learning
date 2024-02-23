package hasan.almu.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Test with TestInfo")
public class InformationTest {

    @Test
    @Tag("cool")
    @DisplayName("this is test one")
    public void testInfo(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTestMethod());
        System.out.println(testInfo.getTestClass());
        System.out.println(testInfo.getTags());
    }
}
