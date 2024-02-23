package hasanalmu.IO;

import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.io.StringWriter;

public class VariableMemoryTest {

    @Test
    void test() {
        StringWriter writer = new StringWriter();
        for (int i = 0; i < 10; i++) {
            int index = i;
            writer.write("hello word "+index + "\n" );
            writer.flush();
        }
//        System.out.println(writer.getBuffer().toString());
    }
}
